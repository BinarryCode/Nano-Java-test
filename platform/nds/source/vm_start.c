/*
 * vm_start.c - creates and runs the VM for the chosen MIDlet.
 *
 * The Java heap is sized from whatever memory malloc can still get from
 * the system, so it grows automatically on DSi (16 MB) compared to DS
 * (4 MB). Limits that live in native memory are scaled up on DSi only.
 */
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <stdbool.h>

#include "nds_platform.h"
#include "classlib_bin.h"
#include "../../../src/vm/vm.h"
#include "../../../src/util/zip.h"
#include "../../../src/midp/midp.h"

/* Native memory kept outside the Java heap for class metadata, thread
 * stacks and image decoding. DSi gets more because the VM limits below
 * are raised there. */
#define NATIVE_RESERVE_SMALL (1u << 20)
#define NATIVE_RESERVE_LARGE (2u << 20)

/* At or above this much free memory we treat the system as DSi-class. */
#define LARGE_MEM_THRESHOLD (8u << 20)

/* Smallest Java heap worth starting with. */
#define MIN_HEAP (1u << 20)

/* Heap size is rounded down to this. */
#define HEAP_ALIGN 4096u

/* Optional hard cap on the Java heap in bytes (0 = no cap). Build with
 * -DNJ_MAX_HEAP=... if the VM misbehaves with very large heaps. */
#ifndef NJ_MAX_HEAP
#define NJ_MAX_HEAP 0u
#endif

/* Present only in test builds made with `make nds-embed JAR=...`. */
extern const uint8_t app_bin[] __attribute__((weak));
extern const uint8_t app_bin_end[] __attribute__((weak));

bool nds_has_embedded_app(void)
{
    return app_bin != NULL && app_bin_end != NULL;
}

/* libnds (nds/system.h, which cannot be included here). */
uint8_t *getHeapEnd(void);
uint8_t *getHeapLimit(void);

/* Memory malloc can still get from the system: the space between the
 * current end of the heap and its limit (about 4 MB on DS, up to 16 MB
 * on DSi when the ROM runs in DSi mode). */
static size_t free_memory(void)
{
    uint8_t *end = getHeapEnd();
    uint8_t *limit = getHeapLimit();
    return limit > end ? (size_t)(limit - end) : 0;
}

void nds_set_jad(const uint8_t *data, uint32_t len)
{
    res_set_jad(data, len);
}

void nds_stop_vm(void)
{
    vm.exit_requested = true;
}

int nds_run_vm(const char *jar_path, const char *midlet_class, GameSettings *s)
{
    size_t free_mem = free_memory();
    printf("Heap end %p, limit %p, free %u KB\n",
           (void *)getHeapEnd(), (void *)getHeapLimit(),
           (unsigned)(free_mem >> 10));

    /* Pick the memory profile from how much is really available. */
    size_t reserve = NATIVE_RESERVE_SMALL;
    unsigned scale = 1;
    if (free_mem >= LARGE_MEM_THRESHOLD) {
        reserve = NATIVE_RESERVE_LARGE;
        scale = 4;
    } else {
        printf("Only %u KB free: DS-sized heap. DSi mode may be off.\n",
               (unsigned)(free_mem >> 10));
    }

    if (free_mem < reserve + MIN_HEAP)
        pal_fatal("Not enough memory.");

    size_t heap = (free_mem - reserve) & ~(size_t)(HEAP_ALIGN - 1);
    if (NJ_MAX_HEAP && heap > NJ_MAX_HEAP)
        heap = NJ_MAX_HEAP;

    VMOptions opt = {heap, 4096 * scale, 256 * scale, false, false, false};
    vm_init(&opt);
    midp_init();

    Zip *classlib = zip_open_mem(classlib_bin, (uint32_t)classlib_bin_size);
    if (!classlib)
        pal_fatal("The built-in class library is damaged.");
    res_set_system(classlib);
    Zip *app = jar_path ? zip_open_file(jar_path)
                        : zip_open_mem(app_bin, (uint32_t)(app_bin_end - app_bin));
    if (!app)
        pal_fatal("Cannot open the .jar file.");
    res_add_app_zip(app);

    printf("Starting %s\n", jar_path ? jar_path : "embedded MIDlet");
    printf("Java heap: %u KB, native reserve: %u KB\n",
           (unsigned)(opt.heap_size >> 10), (unsigned)(reserve >> 10));
    nds_session_start(s, jar_path);

    const char *boot_args[] = {"-midlet", midlet_class ? midlet_class : ""};
    if (!vm_boot(boot_args, 2))
        pal_fatal("The VM failed to start.");
    vm_poll_hook = midp_poll;
    int code = vm_run();
    if (vm.uncaught)
        code = 1;
    vm_shutdown();
    midp_shutdown();
    return code;
}
