package com.nokia.mid.payment;

/** Stub of the Nokia In-App Purchase callback interface. */
public interface IAPClientPaymentListener {
    int OK = 1;
    int BAD_REQUEST = -1;
    int AUTH_FAILED = -2;
    int FORBIDDEN = -3;
    int NOT_FOUND = -4;
    int SERVER_ERROR = -5;
    int SERVICE_UNAVAILABLE = -6;
    int UNKNOWN_SERVICE = -7;
    int INVALID_PRODUCT_ID = -8;
    int PRODUCT_INFO_FAILED = -9;
    int INVALID_PRICE = -10;
    int CUST_INFO_FAILED = -11;
    int PMT_INSTR_FAILED = -12;
    int NO_PMT_METHODS = -13;
    int PURCHASE_SESSION_FAILED = -14;
    int UNKNOWN_PRODUCT = -15;
    int INVALID_PRODUCT_DATA = -16;
    int DELIVERY_LIMIT_EXCEEDED = -17;
    int RESTORABLE = -18;
    int RESTORATION_NOT_ALLOWED = -19;
    int RESTORATION_LMT_EXCEEDED = -20;
    int RESTORATION_DEVICE_LMT_EXCEEDED = -21;
    int GENERAL_PRODUCT_ERROR = -22;
    int DRM_SERVER_ERROR = -23;
    int LICENSE_ACTIVATION_ERROR = -24;
    int SILENT_OPER_FAILED = -25;
    int OVI_SIGN_IN_FAILED = -26;
    int SMS_PMT_FAILED = -27;
    int OPERATOR_BILLING_FAILED = -28;
    int PMT_INSTR_UNAUTHORIZED = -29;
    int UNKNOWN_TRANSACTION_ID = -30;
    int TIMEOUT = -31;
    int TIMEOUT_DELIVERED = -32;
    int GENERAL_PURCHASE_ERROR = -33;
    int OPERATION_FAILED = -34;
    int GENERAL_HTTP_ERROR = -35;
    int USER_AND_DEVICE_INFO_FAILED = -36;
    int RESTORATION_FAILED = -37;

    void productDataReceived(int status, IAPClientProductData pd);

    void productDataListReceived(int status, IAPClientProductData[] productDataList);

    void purchaseCompleted(int status, String purchaseTicket);

    void restorationCompleted(int status, String purchaseTicket);

    void restorableProductsReceived(int status, IAPClientProductData[] productDataList);

    void userAndDeviceDataReceived(int status, IAPClientUserAndDeviceData ud);
}
