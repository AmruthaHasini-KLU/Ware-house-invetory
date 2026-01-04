package com.ware.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "salesorder")
public class SalesOrder {

    @Id
    private int orderId;
    private int warehouseId;
    private int customerId;
    private Date orderDate;
    private Date promisedDate;
    private String status;

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }

    public Date getPromisedDate() { return promisedDate; }
    public void setPromisedDate(Date promisedDate) { this.promisedDate = promisedDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
