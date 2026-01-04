package com.ware.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ware.entity.SalesOrder;
import com.ware.util.HibernateUtil;

public class SalesOrderDAO {

    public void save(SalesOrder so) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(so);
        tx.commit();
        s.close();
    }

    // RPT-12: Bulk Delete Old Cancelled Orders
    public int deleteOldCancelledOrders(Date cutoffDate) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();

        String hql = "delete from SalesOrder o where o.status = 'CANCELLED' and o.orderDate < :cutoffDate";
        Query<?> query = s.createQuery(hql);
        query.setParameter("cutoffDate", cutoffDate);

        int deletedCount = query.executeUpdate();

        tx.commit();
        s.close();

        return deletedCount;
    }
}
