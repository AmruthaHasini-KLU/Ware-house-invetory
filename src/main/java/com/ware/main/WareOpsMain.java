package com.ware.main;

import java.util.Scanner;
import com.ware.dao.*;
import com.ware.entity.*;

public class WareOpsMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        WarehouseDAO warehouseDAO = new WarehouseDAO();
        SupplierDAO supplierDAO = new SupplierDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        BinDAO binDAO = new BinDAO();
        PurchaseReceiptDAO purchaseReceiptDAO = new PurchaseReceiptDAO();
        PurchaseItemDAO purchaseItemDAO = new PurchaseItemDAO();
        SalesOrderDAO salesOrderDAO = new SalesOrderDAO();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        DispatchDAO dispatchDAO = new DispatchDAO();
        ReturnLogDAO returnDAO = new ReturnLogDAO();

        while (true) {

            System.out.println("\n===== WareOps Lite Menu =====");
            System.out.println("1. Add Warehouse");
            System.out.println("2. Add Supplier");
            System.out.println("3. Add Customer");
            System.out.println("4. Add Product");
            System.out.println("5. Add Bin");
            System.out.println("6. Create Purchase Receipt");
            System.out.println("7. Create Sales Order");
            System.out.println("8. Dispatch Order");
            System.out.println("9. Process Return");
            System.out.println("10. Deactivate Product");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    Warehouse w = new Warehouse();
                    System.out.print("Warehouse ID: ");
                    w.setWarehouseId(sc.nextInt());
                    System.out.print("Name: ");
                    w.setName(sc.next());
                    System.out.print("City: ");
                    w.setCity(sc.next());
                    System.out.print("Status (ACTIVE/INACTIVE): ");
                    w.setStatus(sc.next());
                    warehouseDAO.save(w);
                    System.out.println("Warehouse saved");
                    break;

                case 2:
                    Supplier s = new Supplier();
                    System.out.print("Supplier ID: ");
                    s.setSupplierId(sc.nextInt());
                    System.out.print("Name: ");
                    s.setName(sc.next());
                    System.out.print("GST: ");
                    s.setGstNumber(sc.next());
                    System.out.print("Phone: ");
                    s.setPhone(sc.next());
                    System.out.print("City: ");
                    s.setCity(sc.next());
                    System.out.print("Status: ");
                    s.setStatus(sc.next());
                    supplierDAO.save(s);
                    System.out.println("Supplier saved");
                    break;

                case 3:
                    Customer c = new Customer();
                    System.out.print("Customer ID: ");
                    c.setCustomerId(sc.nextInt());
                    System.out.print("Name: ");
                    c.setName(sc.next());
                    System.out.print("Phone: ");
                    c.setPhone(sc.next());
                    System.out.print("City: ");
                    c.setCity(sc.next());
                    System.out.print("Type (RETAIL/WHOLESALE): ");
                    c.setCustomerType(sc.next());
                    customerDAO.save(c);
                    System.out.println("Customer saved");
                    break;

                case 4:
                    Product p = new Product();
                    System.out.print("Product ID: ");
                    p.setProductId(sc.nextInt());
                    System.out.print("SKU: ");
                    p.setSku(sc.next());
                    System.out.print("Name: ");
                    p.setName(sc.next());
                    System.out.print("Category: ");
                    p.setCategory(sc.next());
                    System.out.print("Unit Price: ");
                    p.setUnitPrice(sc.nextDouble());
                    System.out.print("Reorder Level: ");
                    p.setReorderLevel(sc.nextInt());
                    System.out.print("Status: ");
                    p.setStatus(sc.next());
                    productDAO.save(p);
                    System.out.println("Product saved");
                    break;

                case 5:
                    Bin b = new Bin();
                    System.out.print("Bin ID: ");
                    b.setBinId(sc.nextInt());
                    System.out.print("Warehouse ID: ");
                    b.setWarehouseId(sc.nextInt());
                    System.out.print("Code: ");
                    b.setCode(sc.next());
                    System.out.print("Zone: ");
                    b.setZone(sc.next());
                    System.out.print("Capacity: ");
                    b.setCapacity(sc.nextInt());
                    System.out.print("Status: ");
                    b.setStatus(sc.next());
                    binDAO.save(b);
                    System.out.println("Bin saved");
                    break;

                case 6:
                    PurchaseReceipt pr = new PurchaseReceipt();
                    System.out.print("Receipt ID: ");
                    pr.setReceiptId(sc.nextInt());
                    System.out.print("Warehouse ID: ");
                    pr.setWarehouseId(sc.nextInt());
                    System.out.print("Supplier ID: ");
                    pr.setSupplierId(sc.nextInt());
                    pr.setReceiptDate(new java.util.Date());
                    System.out.print("Invoice No: ");
                    pr.setInvoiceNo(sc.next());
                    System.out.print("Total Amount: ");
                    pr.setTotalAmount(sc.nextDouble());
                    purchaseReceiptDAO.save(pr);
                    System.out.println("Purchase Receipt saved");
                    break;

                case 7:
                    SalesOrder so = new SalesOrder();
                    System.out.print("Order ID: ");
                    so.setOrderId(sc.nextInt());
                    System.out.print("Warehouse ID: ");
                    so.setWarehouseId(sc.nextInt());
                    System.out.print("Customer ID: ");
                    so.setCustomerId(sc.nextInt());
                    so.setOrderDate(new java.util.Date());
                    so.setPromisedDate(new java.util.Date());
                    so.setStatus("NEW");
                    salesOrderDAO.save(so);
                    System.out.println("Sales Order created");
                    break;

                case 8:
                    Dispatch d = new Dispatch();
                    System.out.print("Dispatch ID: ");
                    d.setDispatchId(sc.nextInt());
                    System.out.print("Warehouse ID: ");
                    d.setWarehouseId(sc.nextInt());
                    System.out.print("Order ID: ");
                    d.setOrderId(sc.nextInt());
                    d.setDispatchDate(new java.util.Date());
                    System.out.print("Courier: ");
                    d.setCourier(sc.next());
                    System.out.print("Tracking No: ");
                    d.setTrackingNo(sc.next());
                    d.setStatus("IN_TRANSIT");
                    dispatchDAO.save(d);
                    System.out.println("Order dispatched");
                    break;

                case 9:
                    ReturnLog r = new ReturnLog();
                    System.out.print("Return ID: ");
                    r.setReturnId(sc.nextInt());
                    System.out.print("Warehouse ID: ");
                    r.setWarehouseId(sc.nextInt());
                    System.out.print("Order ID: ");
                    r.setOrderId(sc.nextInt());
                    System.out.print("Product ID: ");
                    r.setProductId(sc.nextInt());
                    r.setReturnDate(new java.util.Date());
                    System.out.print("Qty: ");
                    r.setQty(sc.nextInt());
                    System.out.print("Reason: ");
                    r.setReason(sc.next());
                    System.out.print("Refund Amount: ");
                    r.setRefundAmount(sc.nextDouble());
                    r.setStatus("OPEN");
                    returnDAO.save(r);
                    System.out.println("Return processed");
                    break;

                case 10:
                    System.out.print("Enter Product ID to deactivate: ");
                    productDAO.deactivate(sc.nextInt());
                    System.out.println("Product deactivated");
                    break;

                case 0:
                    System.out.println("Exiting WareOps Lite...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
