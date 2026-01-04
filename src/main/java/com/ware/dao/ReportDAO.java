package com.ware.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ware.entity.SalesOrder;
import com.ware.util.HibernateUtil;

public class ReportDAO {

    // RPT-01: Monthly Sales Revenue by Warehouse
    public List<Object[]> monthlySalesRevenue(int month, int year) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select o.warehouseId, sum(i.qty * i.sellingPrice) " +
                     "from SalesOrder o, OrderItem i " +
                     "where o.orderId = i.orderId " +
                     "and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                     "and o.status <> 'CANCELLED' " +
                     "group by o.warehouseId " +
                     "order by sum(i.qty * i.sellingPrice) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("m", month);
        q.setParameter("y", year);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-02: Top Selling Products by Quantity
    public List<Object[]> topSellingProducts(int month, int year) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select i.productId, sum(i.qty) " +
                     "from SalesOrder o, OrderItem i " +
                     "where o.orderId = i.orderId " +
                     "and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                     "and o.status <> 'CANCELLED' " +
                     "group by i.productId " +
                     "order by sum(i.qty) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("m", month);
        q.setParameter("y", year);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-03: Low Stock Alert
    public List<Object[]> lowStockAlert(int warehouseId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select p.productId, " +
                     "sum(case when l.movementType='IN' then l.qty else -l.qty end), " +
                     "p.reorderLevel " +
                     "from Product p, StockLedger l " +
                     "where p.productId = l.productId " +
                     "and l.warehouseId = :wid " +
                     "group by p.productId, p.reorderLevel " +
                     "having sum(case when l.movementType='IN' then l.qty else -l.qty end) < p.reorderLevel " +
                     "order by p.productId asc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("wid", warehouseId);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-04: Supplier Spend
    public List<Object[]> supplierSpend(int month, int year) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select r.supplierId, sum(pi.qty * pi.unitCost) " +
                     "from PurchaseReceipt r, PurchaseItem pi " +
                     "where r.receiptId = pi.receiptId " +
                     "and month(r.receiptDate)=:m and year(r.receiptDate)=:y " +
                     "group by r.supplierId " +
                     "order by sum(pi.qty * pi.unitCost) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("m", month);
        q.setParameter("y", year);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-05: Inbound vs Outbound Trend
    public List<Object[]> inboundOutboundTrend(int warehouseId, Date fromDate, Date toDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select l.movementDate, " +
                     "sum(case when l.movementType='IN' then l.qty else 0 end), " +
                     "sum(case when l.movementType='OUT' then l.qty else 0 end) " +
                     "from StockLedger l " +
                     "where l.warehouseId = :wid " +
                     "and l.movementDate between :from and :to " +
                     "group by l.movementDate " +
                     "order by l.movementDate asc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("wid", warehouseId);
        q.setParameter("from", fromDate);
        q.setParameter("to", toDate);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-06: Late Deliveries
    public List<Object[]> lateDeliveries(int warehouseId, Date fromDate, Date toDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select d.dispatchId, d.orderId, o.promisedDate, d.deliveredDate, d.courier " +
                     "from Dispatch d, SalesOrder o " +
                     "where d.orderId = o.orderId " +
                     "and d.warehouseId = :wid " +
                     "and d.deliveredDate is not null " +
                     "and d.deliveredDate > o.promisedDate " +
                     "and d.dispatchDate between :from and :to " +
                     "order by d.deliveredDate desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("wid", warehouseId);
        q.setParameter("from", fromDate);
        q.setParameter("to", toDate);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-07: Return Rate by Product
    public List<Object[]> returnRateByProduct(int warehouseId, Date fromDate, Date toDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select r.productId, sum(r.qty) " +
                     "from ReturnLog r " +
                     "where r.warehouseId = :wid " +
                     "and r.returnDate between :from and :to " +
                     "group by r.productId " +
                     "order by sum(r.qty) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("wid", warehouseId);
        q.setParameter("from", fromDate);
        q.setParameter("to", toDate);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-08: Customer Revenue Ranking
    public List<Object[]> customerRevenueRanking(int month, int year) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select o.customerId, sum(i.qty * i.sellingPrice) " +
                     "from SalesOrder o, OrderItem i " +
                     "where o.orderId = i.orderId " +
                     "and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                     "and o.status <> 'CANCELLED' " +
                     "group by o.customerId " +
                     "order by sum(i.qty * i.sellingPrice) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("m", month);
        q.setParameter("y", year);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-09: Revenue With Customer Names
    public List<Object[]> revenueWithCustomerNames(int month, int year) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "select c.name, sum(i.qty * i.sellingPrice) " +
                     "from Customer c, SalesOrder o, OrderItem i " +
                     "where c.customerId = o.customerId " +
                     "and o.orderId = i.orderId " +
                     "and month(o.orderDate)=:m and year(o.orderDate)=:y " +
                     "and o.status <> 'CANCELLED' " +
                     "group by c.name " +
                     "order by sum(i.qty * i.sellingPrice) desc";
        Query<Object[]> q = s.createQuery(hql, Object[].class);
        q.setParameter("m", month);
        q.setParameter("y", year);
        List<Object[]> result = q.list();
        s.close();
        return result;
    }

    // RPT-10: Paged Order Listing
    public List<SalesOrder> pagedOrderListing(int warehouseId, int pageNo, int pageSize) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "from SalesOrder o where o.warehouseId = :wid order by o.orderDate desc";
        Query<SalesOrder> q = s.createQuery(hql, SalesOrder.class);
        q.setParameter("wid", warehouseId);
        q.setFirstResult((pageNo - 1) * pageSize);
        q.setMaxResults(pageSize);
        List<SalesOrder> result = q.list();
        s.close();
        return result;
    }

    // RPT-11: Bulk Close Old Returns
    public int closeOldReturns(Date cutoffDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        String hql = "update ReturnLog r set r.status='CLOSED' where r.status='OPEN' and r.returnDate < :cutoff";
        Query<?> q = s.createQuery(hql);
        q.setParameter("cutoff", cutoffDate);
        int updated = q.executeUpdate();
        tx.commit();
        s.close();
        return updated;
    }

    // RPT-12: Bulk Delete Old Cancelled Orders
    public int deleteOldCancelledOrders(Date cutoffDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        String hql = "delete from SalesOrder o where o.status='CANCELLED' and o.orderDate < :cutoff";
        Query<?> q = s.createQuery(hql);
        q.setParameter("cutoff", cutoffDate);
        int deleted = q.executeUpdate();
        tx.commit();
        s.close();
        return deleted;
    }
}
