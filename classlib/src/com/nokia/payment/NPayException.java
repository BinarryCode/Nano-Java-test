package com.nokia.payment;

/** Stub of the Nokia In-App Payment exception. */
public class NPayException extends Exception {
    public static final int NO_ERROR_CODE = 0;
    public static final int ERR_PARAM_IS_NULL = 1;
    public static final int ERR_NIAP_LIBRARY_INIT = 2;
    public static final int ERR_NO_IAP_RESPONSE_LISTENER = 3;
    public static final int ERR_NPAY_INVOKE = 4;
    public static final int ERR_NO_IAP_MIDLET_AUTHORITY = 5;
    public static final int ERR_IAP_MIDLET_AUTHORITY_NOT_TRUSTED = 6;
    public static final int ERR_PARAM_IS_EMPTY = 7;

    private int code = NO_ERROR_CODE;

    public NPayException(String message) {
        super(message);
    }

    public NPayException(String message, int code) {
        super(message);
        this.code = code;
    }

    public int getErrorCode() {
        return code;
    }
}
