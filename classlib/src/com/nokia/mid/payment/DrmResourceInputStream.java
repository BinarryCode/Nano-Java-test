package com.nokia.mid.payment;

import java.io.IOException;
import java.io.InputStream;

/** Stub of the Nokia DRM resource stream: always empty (immediate end of stream). */
public class DrmResourceInputStream extends InputStream {
    public int read() throws IOException {
        return -1;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        return -1;
    }

    public int available() throws IOException {
        return 0;
    }

    public long skip(long n) throws IOException {
        return 0;
    }

    public void close() throws IOException {
    }

    public void mark(int readlimit) {
    }

    public boolean markSupported() {
        return false;
    }

    public void reset() throws IOException {
    }
}
