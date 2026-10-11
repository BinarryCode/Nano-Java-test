package javax.bluetooth;

import java.io.IOException;

/** Stub: Bluetooth is not supported on this platform. */
public interface ServiceRecord {
    int NOAUTHENTICATE_NOENCRYPT = 0x00;
    int AUTHENTICATE_NOENCRYPT = 0x01;
    int AUTHENTICATE_ENCRYPT = 0x02;

    DataElement getAttributeValue(int attrID);
    RemoteDevice getHostDevice();
    int[] getAttributeIDs();
    boolean populateRecord(int[] attrIDs) throws IOException;
    String getConnectionURL(int requiredSecurity, boolean mustBeMaster);
    void setDeviceServiceClasses(int classes);
    boolean setAttributeValue(int attrID, DataElement attrValue);
}
