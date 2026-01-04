package com.ware.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispatch")
public class Dispatch {

    @Id
    private int dispatchId;
    private int warehouseId;
    private int orderId;
    private Date dispatchDate;
    private String courier;
    private String trackingNo;
    private Date deliveredDate;
    private String status;

    public int getDispatchId() { return dispatchId; }
    public void setDispatchId(int dispatchId) { this.dispatchId = dispatchId; }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }

    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public Date getDispatchDate() { return dispatchDate; }
    public void setDispatchDate(Date dispatchDate) { this.dispatchDate = dispatchDate; }

    public String getCourier() { return courier; }
    public void setCourier(String courier) { this.courier = courier; }

    public String getTrackingNo() { return trackingNo; }
    public void setTrackingNo(String trackingNo) { this.trackingNo = trackingNo; }

    public Date getDeliveredDate() { return deliveredDate; }
    public void setDeliveredDate(Date deliveredDate) { this.deliveredDate = deliveredDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
