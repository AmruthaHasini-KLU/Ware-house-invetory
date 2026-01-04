package com.ware.main;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        ReportDAO reportDAO = new ReportDAO();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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
            System.out.println("11. Bulk Close Old Returns");
            System.out.println("12. Monthly Sales Revenue by Warehouse");
            System.out.println("13. Top Selling Products by Quantity");
            System.out.println("14. Low Stock Alert");
            System.out.println("15. Supplier Spend (Monthly)");
            System.out.println("16. Inbound vs Outbound Movement");
            System.out.println("17. Late Deliveries");
            System.out.println("18. Return Rate by Product");
            System.out.println("19. Customer Revenue Ranking");
            System.out.println("20. Readable Revenue With Customer Names");
            System.out.println("21. Paged Order Listing");
            System.out.println("22. Bulk Delete Old Cancelled Orders");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            try {
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
                        pr.setReceiptDate(new Date());
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
                        so.setOrderDate(new Date());
                        so.setPromisedDate(new Date());
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
                        d.setDispatchDate(new Date());
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
                        r.setReturnDate(new Date());
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

                    case 11:
                        System.out.print("Enter cutoff date (yyyy-MM-dd): ");
                        String cutoff = sc.next();
                        Date cutoffDate = sdf.parse(cutoff);
                        int updated = returnDAO.bulkCloseOldReturns(cutoffDate);
                        System.out.println(updated + " old returns closed.");
                        break;

                    case 12:
                        System.out.print("Enter month (1-12): ");
                        int month = sc.nextInt();
                        System.out.print("Enter year: ");
                        int year = sc.nextInt();
                        reportDAO.monthlySalesRevenue(month, year)
                                .forEach(rpt -> System.out.println("Warehouse " + rpt[0] + ": Revenue = " + rpt[1]));
                        break;

                    case 13:
                        System.out.print("Enter month (1-12): ");
                        month = sc.nextInt();
                        System.out.print("Enter year: ");
                        year = sc.nextInt();
                        reportDAO.topSellingProducts(month, year)
                                .forEach(rpt -> System.out.println("Product " + rpt[0] + ": Sold Qty = " + rpt[1]));
                        break;

                    case 14:
                        System.out.print("Enter Warehouse ID: ");
                        int warehouseId = sc.nextInt();
                        reportDAO.lowStockAlert(warehouseId)
                                .forEach(rpt -> System.out.println("Product " + rpt[0] + ": Stock = " + rpt[1] + ", Reorder Level = " + rpt[2]));
                        break;

                    case 15:
                        System.out.print("Enter month (1-12): ");
                        month = sc.nextInt();
                        System.out.print("Enter year: ");
                        year = sc.nextInt();
                        reportDAO.supplierSpend(month, year)
                                .forEach(rpt -> System.out.println("Supplier " + rpt[0] + ": Spend = " + rpt[1]));
                        break;

                    case 16:
                        System.out.print("Enter Warehouse ID: ");
                        warehouseId = sc.nextInt();
                        System.out.print("Enter From Date (yyyy-MM-dd): ");
                        String from = sc.next();
                        System.out.print("Enter To Date (yyyy-MM-dd): ");
                        String to = sc.next();
                        Date fromDate = sdf.parse(from);
                        Date toDate = sdf.parse(to);
                        reportDAO.inboundOutboundTrend(warehouseId, fromDate, toDate)
                                .forEach(rpt -> System.out.println(rpt[0] + ": IN=" + rpt[1] + ", OUT=" + rpt[2]));
                        break;

                    case 17:
                        System.out.print("Enter Warehouse ID: ");
                        warehouseId = sc.nextInt();
                        System.out.print("Enter From Date (yyyy-MM-dd): ");
                        from = sc.next();
                        System.out.print("Enter To Date (yyyy-MM-dd): ");
                        to = sc.next();
                        fromDate = sdf.parse(from);
                        toDate = sdf.parse(to);
                        reportDAO.lateDeliveries(warehouseId, fromDate, toDate)
                                .forEach(rpt -> System.out.println("Dispatch " + rpt[0] + ", Order " + rpt[1] + ", Promised: " + rpt[2] + ", Delivered: " + rpt[3] + ", Courier: " + rpt[4]));
                        break;

                    case 18:
                        System.out.print("Enter Warehouse ID: ");
                        warehouseId = sc.nextInt();
                        System.out.print("Enter From Date (yyyy-MM-dd): ");
                        from = sc.next();
                        System.out.print("Enter To Date (yyyy-MM-dd): ");
                        to = sc.next();
                        fromDate = sdf.parse(from);
                        toDate = sdf.parse(to);
                        reportDAO.returnRateByProduct(warehouseId, fromDate, toDate)
                                .forEach(rpt -> System.out.println("Product " + rpt[0] + ": Return Qty = " + rpt[1]));
                        break;

                    case 19:
                        System.out.print("Enter month (1-12): ");
                        month = sc.nextInt();
                        System.out.print("Enter year: ");
                        year = sc.nextInt();
                        reportDAO.customerRevenueRanking(month, year)
                                .forEach(rpt -> System.out.println("Customer " + rpt[0] + ": Revenue = " + rpt[1]));
                        break;

                    case 20:
                        System.out.print("Enter month (1-12): ");
                        month = sc.nextInt();
                        System.out.print("Enter year: ");
                        year = sc.nextInt();
                        reportDAO.revenueWithCustomerNames(month, year)
                                .forEach(rpt -> System.out.println("Customer " + rpt[0] + ": Revenue = " + rpt[1]));
                        break;

                    case 21:
                        System.out.print("Enter Warehouse ID: ");
                        warehouseId = sc.nextInt();
                        System.out.print("Enter Page No: ");
                        int pageNo = sc.nextInt();
                        System.out.print("Enter Page Size: ");
                        int pageSize = sc.nextInt();
                        reportDAO.pagedOrderListing(warehouseId, pageNo, pageSize)
                                .forEach(rpt -> System.out.println("Order " + ((SalesOrder) rpt).getOrderId() + ", Status: " + ((SalesOrder) rpt).getStatus()));
                        break;

                    case 22:
                        System.out.print("Enter cutoff date (yyyy-MM-dd): ");
                        cutoff = sc.next();
                        cutoffDate = sdf.parse(cutoff);
                        int deleted = salesOrderDAO.deleteOldCancelledOrders(cutoffDate);
                        System.out.println(deleted + " old cancelled orders deleted.");
                        break;

                    case 0:
                        System.out.println("Exiting WareOps Lite...");
                        sc.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
