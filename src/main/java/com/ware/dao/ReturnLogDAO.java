package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.ReturnLog;
import com.ware.util.HibernateUtil;

public class ReturnLogDAO {

    public void save(ReturnLog r) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(r);
        tx.commit();
        s.close();
    }
}
