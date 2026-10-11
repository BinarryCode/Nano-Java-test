package com.nokia.payment;

import javax.microedition.midlet.MIDlet;

/**
 * Stub of the Nokia In-App Payment manager. Every purchase "succeeds"
 * immediately so the game believes the item was paid for.
 */
public class NPayManager {
    private NPayListener listener;

    public NPayManager(MIDlet midlet) throws NPayException {
        if (midlet == null)
            throw new NPayException("NPayManager received null MIDlet",
                    NPayException.ERR_PARAM_IS_NULL);
    }

    public void getProductData(String[] productIdList) throws NPayException {
        if (productIdList == null)
            throw new NPayException("productIdList is null",
                    NPayException.ERR_PARAM_IS_NULL);
        if (productIdList.length == 0)
            throw new NPayException("productIdList is empty",
                    NPayException.ERR_PARAM_IS_EMPTY);
        if (listener == null)
            throw new NPayException("No listener set",
                    NPayException.ERR_NO_IAP_RESPONSE_LISTENER);

        ProductData[] data = new ProductData[productIdList.length];
        for (int i = 0; i < data.length; i++)
            data[i] = new ProductData(productIdList[i], "0.00", "$");
        listener.productDataReceived(data);
    }

    public boolean isNPayAvailable() {
        return true;
    }

    public void launchNPaySetup() {
    }

    public void purchaseProduct(String productId) throws NPayException {
        purchaseProduct("0", productId);
    }

    public void purchaseProduct(String contentId, String productId) throws NPayException {
        if (productId == null)
            throw new NPayException("productId is null",
                    NPayException.ERR_PARAM_IS_NULL);
        if (listener == null)
            throw new NPayException("No listener set",
                    NPayException.ERR_NO_IAP_RESPONSE_LISTENER);

        listener.purchaseCompleted(new PurchaseData(contentId, productId,
                PurchaseData.PURCHASE_SUCCESS, "RequestPurchase", "AllowStub"));
    }

    public void setNPayListener(NPayListener listener) {
        this.listener = listener;
    }
}
