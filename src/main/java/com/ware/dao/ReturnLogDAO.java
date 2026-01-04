package com.ware.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ware.entity.ReturnLog;
import com.ware.util.HibernateUtil;

public class ReturnLogDAO {

    // Save single return
    public void save(ReturnLog r) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(r);
        tx.commit();
        session.close();
    }

    // Bulk close old returns (status = OPEN -> CLOSED)
    public int bulkCloseOldReturns(Date cutoffDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // HQL update query
        String hql = "UPDATE ReturnLog r SET r.status = 'CLOSED' WHERE r.returnDate < :cutoffDate AND r.status = 'OPEN'";
        int updated = session.createQuery(hql)
                .setParameter("cutoffDate", cutoffDate)
                .executeUpdate();

        tx.commit();
        session.close();

        return updated; // number of rows updated
    }
}
