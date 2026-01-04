package com.ware.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {

    @Id
    private int supplierId;
    private String name;
    private String gstNumber;
    private String phone;
    private String city;
    private String status;

    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGstNumber() { return gstNumber; }
    public void setGstNumber(String gstNumber) { this.gstNumber = gstNumber; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
