package com.ware.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchaseitem")
public class PurchaseItem {

    @Id
    private int purchaseItemId;
    private int receiptId;
    private int productId;
    private int qty;
    private double unitCost;

    // getters & setters
    public int getPurchaseItemId() { return purchaseItemId; }
    public void setPurchaseItemId(int purchaseItemId) { this.purchaseItemId = purchaseItemId; }

    public int getReceiptId() { return receiptId; }
    public void setReceiptId(int receiptId) { this.receiptId = receiptId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public double getUnitCost() { return unitCost; }
    public void setUnitCost(double unitCost) { this.unitCost = unitCost; }
}
