package javax.bluetooth;

/** Stub: Bluetooth is not supported on this platform. */
public class DataElement {
    public static final int NULL = 0x0000;
    public static final int U_INT_1 = 0x0008;
    public static final int U_INT_2 = 0x0009;
    public static final int U_INT_4 = 0x000A;
    public static final int U_INT_8 = 0x000B;
    public static final int U_INT_16 = 0x000C;
    public static final int INT_1 = 0x0010;
    public static final int INT_2 = 0x0011;
    public static final int INT_4 = 0x0012;
    public static final int INT_8 = 0x0013;
    public static final int INT_16 = 0x0014;
    public static final int URL = 0x0040;
    public static final int UUID = 0x0018;
    public static final int BOOL = 0x0028;
    public static final int STRING = 0x0020;
    public static final int DATSEQ = 0x0030;
    public static final int DATALT = 0x0038;

    private int type;
    private long longValue;
    private Object objValue;

    public DataElement(int valueType) {
        type = valueType;
    }

    public DataElement(boolean bool) {
        type = BOOL;
        longValue = bool ? 1 : 0;
    }

    public DataElement(int valueType, long value) {
        type = valueType;
        longValue = value;
    }

    public DataElement(int valueType, Object value) {
        type = valueType;
        objValue = value;
    }

    public void addElement(DataElement elem) {
    }

    public void insertElementAt(DataElement elem, int index) {
    }

    public boolean removeElement(DataElement elem) {
        return false;
    }

    public int getDataType() {
        return type;
    }

    public long getLong() {
        return longValue;
    }

    public boolean getBoolean() {
        return longValue != 0;
    }

    public Object getValue() {
        return objValue;
    }

    public int getSize() {
        return 0;
    }
}
