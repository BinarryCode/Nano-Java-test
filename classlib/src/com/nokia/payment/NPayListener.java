package com.nokia.payment;

/** Stub of the Nokia In-App Payment callback interface. */
public interface NPayListener {
    void productDataReceived(ProductData[] productData);

    void purchaseCompleted(PurchaseData response);
}
