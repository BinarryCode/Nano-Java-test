package javax.bluetooth;

import javax.microedition.io.Connection;

/** Stub: Bluetooth is not supported on this platform. */
public class LocalDevice {
    private LocalDevice() {
    }

    public static LocalDevice getLocalDevice() throws BluetoothStateException {
        throw new BluetoothStateException("Bluetooth not supported");
    }

    public DiscoveryAgent getDiscoveryAgent() {
        return null;
    }

    public String getFriendlyName() {
        return null;
    }

    public DeviceClass getDeviceClass() {
        return null;
    }

    public boolean setDiscoverable(int mode) throws BluetoothStateException {
        throw new BluetoothStateException("Bluetooth not supported");
    }

    public static String getProperty(String property) {
        return null;
    }

    public int getDiscoverable() {
        return DiscoveryAgent.NOT_DISCOVERABLE;
    }

    public String getBluetoothAddress() {
        return null;
    }

    public ServiceRecord getRecord(Connection notifier) {
        return null;
    }

    public void updateRecord(ServiceRecord srvRecord)
            throws ServiceRegistrationException {
        throw new ServiceRegistrationException("Bluetooth not supported");
    }
}
