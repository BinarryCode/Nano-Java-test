package com.nokia.payment;

/** Stub of the Nokia In-App Payment purchase result. */
public class PurchaseData {
    public static final int PURCHASE_FAILED = 1;
    public static final int PURCHASE_RESTORE_SUCCESS = 2;
    public static final int PURCHASE_SUCCESS = 0;

    private int status;
    private String contentId;
    private String productId;
    private String requestMessage;
    private String purchaseTicket;

    public PurchaseData(String contentId, String productId, int status,
            String requestMessage, String purchaseTicketInformation) {
        this.contentId = contentId;
        this.productId = productId;
        this.status = status;
        this.requestMessage = requestMessage;
        this.purchaseTicket = purchaseTicketInformation;
    }

    public String getContentId() {
        return contentId;
    }

    public String getMessage() {
        return requestMessage;
    }

    public String getProductId() {
        return productId;
    }

    public String getPurchaseTicket() {
        return purchaseTicket;
    }

    public int getStatus() {
        return status;
    }
}
