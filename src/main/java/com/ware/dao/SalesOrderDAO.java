package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
}
