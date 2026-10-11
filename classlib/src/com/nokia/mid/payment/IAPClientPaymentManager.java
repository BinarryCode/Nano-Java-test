package com.nokia.mid.payment;

import java.io.InputStream;

/**
 * Stub of the Nokia In-App Purchase manager. Every request "succeeds"
 * immediately so the game believes the item was paid for.
 */
public final class IAPClientPaymentManager {
    public static final int DEFAULT_AUTHENTICATION = 0;
    public static final int ONLY_IN_SILENT_AUTHENTICATION = 1;
    public static final int NO_FORCED_RESTORATION = 0;
    public static final int FORCED_AUTOMATIC_RESTORATION = 1;
    public static final int SUCCESS = 1;
    public static final int GENERAL_FAIL = -1;
    public static final int PENDING_REQUEST = -2;
    public static final int NULL_INPUT_PARAMETER = -3;
    public static final int KNI_INTERNAL_FAIL = -4;
    public static final int OUT_OF_MEMORY = -5;
    public static final int TEST_SERVER = 1;
    public static final int SIMULATION = 2;
    public static final int PURCHASE = 101;
    public static final int RESTORE = 102;
    public static final int FAIL = 103;
    public static final int NORMAL = 104;

    private static IAPClientPaymentListener listener;
    private static IAPClientPaymentManager instance;

    private IAPClientPaymentManager() {
    }

    public static synchronized IAPClientPaymentManager getIAPClientPaymentManager()
            throws IAPClientPaymentException {
        if (instance == null)
            instance = new IAPClientPaymentManager();
        return instance;
    }

    public static void setIAPClientPaymentListener(IAPClientPaymentListener iapListener) {
        listener = iapListener;
    }

    public int getProductData(String productId) {
        if (productId == null)
            return NULL_INPUT_PARAMETER;
        if (listener == null)
            return GENERAL_FAIL;
        listener.productDataReceived(IAPClientPaymentListener.OK,
                new IAPClientProductData(productId));
        return SUCCESS;
    }

    public int getProductData(String[] productIdList) {
        if (productIdList == null)
            return NULL_INPUT_PARAMETER;
        if (listener == null)
            return GENERAL_FAIL;
        IAPClientProductData[] products = new IAPClientProductData[productIdList.length];
        for (int i = 0; i < products.length; i++)
            products[i] = new IAPClientProductData(productIdList[i]);
        listener.productDataListReceived(IAPClientPaymentListener.OK, products);
        return SUCCESS;
    }

    public int purchaseProduct(String productId, int forceRestorationFlag) {
        if (productId == null)
            return NULL_INPUT_PARAMETER;
        if (listener == null)
            return GENERAL_FAIL;
        listener.purchaseCompleted(IAPClientPaymentListener.OK, productId);
        return SUCCESS;
    }

    public int restoreProduct(String productId, int authenticationMode) {
        if (productId == null)
            return NULL_INPUT_PARAMETER;
        if (listener == null)
            return GENERAL_FAIL;
        listener.restorationCompleted(IAPClientPaymentListener.OK, productId);
        return SUCCESS;
    }

    public int getRestorableProducts(int authenticationMode) {
        if (listener == null)
            return GENERAL_FAIL;
        listener.restorableProductsReceived(IAPClientPaymentListener.OK,
                new IAPClientProductData[0]);
        return SUCCESS;
    }

    public int getUserAndDeviceId(int authenticationMode) {
        if (listener == null)
            return GENERAL_FAIL;
        listener.userAndDeviceDataReceived(IAPClientPaymentListener.OK,
                new IAPClientUserAndDeviceData());
        return SUCCESS;
    }

    /* DRM-protected resources are just ordinary JAR resources here. */
    public InputStream getDRMResourceAsStream(String name) {
        if (name == null)
            return null;
        if (!name.startsWith("/"))
            name = "/" + name;
        return IAPClientPaymentManager.class.getResourceAsStream(name);
    }
}
