package com.ware.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchasereceipt")
public class PurchaseReceipt {

    @Id
    private int receiptId;
    private int warehouseId;
    private int supplierId;

    @Temporal(TemporalType.DATE)
    private Date receiptDate;

    private String invoiceNo;
    private double totalAmount;

    // getters & setters
    public int getReceiptId() { return receiptId; }
    public void setReceiptId(int receiptId) { this.receiptId = receiptId; }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    public Date getReceiptDate() { return receiptDate; }
    public void setReceiptDate(Date receiptDate) { this.receiptDate = receiptDate; }

    public String getInvoiceNo() { return invoiceNo; }
    public void setInvoiceNo(String invoiceNo) { this.invoiceNo = invoiceNo; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}
