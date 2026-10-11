package javax.bluetooth;

import java.io.IOException;
import javax.microedition.io.Connection;

/** Stub: Bluetooth is not supported on this platform. */
public class RemoteDevice {
    private final String address;

    protected RemoteDevice(String address) {
        if (address == null)
            throw new NullPointerException("address is null");
        this.address = address;
    }

    public static RemoteDevice getRemoteDevice(Connection conn) throws IOException {
        throw new IOException("Bluetooth not supported");
    }

    public String getFriendlyName(boolean alwaysAsk) throws IOException {
        throw new IOException("Bluetooth not supported");
    }

    public final String getBluetoothAddress() {
        return address;
    }

    public boolean equals(Object obj) {
        return obj instanceof RemoteDevice
            && ((RemoteDevice) obj).address.equals(address);
    }

    public int hashCode() {
        return address.hashCode();
    }

    public boolean isTrustedDevice() {
        return false;
    }

    public boolean isAuthenticated() {
        return false;
    }

    public boolean isAuthorized(Connection conn) throws IOException {
        throw new IOException("Bluetooth not supported");
    }

    public boolean isEncrypted() {
        return false;
    }

    public boolean authenticate() throws IOException {
        throw new IOException("Bluetooth not supported");
    }

    public boolean authorize(Connection conn) throws IOException {
        throw new IOException("Bluetooth not supported");
    }

    public boolean encrypt(Connection conn, boolean on) throws IOException {
        throw new IOException("Bluetooth not supported");
    }
}
