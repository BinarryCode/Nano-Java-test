package com.nokia.payment;

/** Stub of the Nokia In-App Payment product description. */
public class ProductData {
    private String productId = "";
    private String localizedPrice = "";
    private String localCurrency = "";

    public ProductData(String productId, String localizedPrice, String localCurrency) {
        this.productId = productId;
        this.localizedPrice = localizedPrice;
        this.localCurrency = localCurrency;
    }

    public String getCurrency() {
        return localCurrency;
    }

    public String getLocalizedPrice() {
        return localizedPrice;
    }

    public String getProductId() {
        return productId;
    }

    /* Report the data as valid so the game treats the product as buyable.
     * If the game misbehaves, try returning false here instead. */
    public boolean isValid() {
        return true;
    }
}
