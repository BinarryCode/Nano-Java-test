package javax.bluetooth;

/** Stub: Bluetooth is not supported on this platform. */
public class UUID {
    private final String value;

    public UUID(long uuidValue) {
        if (uuidValue < 0 || uuidValue > 0xFFFFFFFFL)
            throw new IllegalArgumentException("UUID out of range");
        value = Long.toString(uuidValue, 16).toUpperCase();
    }

    public UUID(String uuidValue, boolean shortUUID) {
        if (uuidValue == null)
            throw new NullPointerException("uuidValue is null");
        value = uuidValue.toUpperCase();
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object value) {
        return value instanceof UUID && ((UUID) value).value.equals(this.value);
    }

    public int hashCode() {
        return value.hashCode();
    }
}
