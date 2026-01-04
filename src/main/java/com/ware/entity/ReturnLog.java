package com.ware.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "returnlog")
public class ReturnLog {

    @Id
    private int returnId;
    private int warehouseId;
    private int orderId;
    private int productId;
    private Date returnDate;
    private int qty;
    private String reason;
    private double refundAmount;
    private String status;

    public int getReturnId() { return returnId; }
    public void setReturnId(int returnId) { this.returnId = returnId; }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public int getQty() { return qty; }
    public void setQty(int qty) { this.qty = qty; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public double getRefundAmount() { return refundAmount; }
    public void setRefundAmount(double refundAmount) { this.refundAmount = refundAmount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
