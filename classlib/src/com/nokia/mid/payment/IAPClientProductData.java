package com.nokia.mid.payment;

/** Stub of the Nokia In-App Purchase product description. */
public class IAPClientProductData {
    public static final int OTHER_DRM = 0;
    public static final int NOKIA_DRM = 1;

    private String productId;

    public IAPClientProductData(String pid) {
        productId = pid;
    }

    public String getProductId() {
        return productId;
    }

    public String getTitle() {
        return "Product";
    }

    public String getShortDescription() {
        return "Product requested by the MIDlet";
    }

    public String getLongDescription() {
        return "Product requested by the MIDlet.";
    }

    public String getPrice() {
        return "$ 0.00";
    }

    public int getDrmProtection() {
        return NOKIA_DRM;
    }
}
