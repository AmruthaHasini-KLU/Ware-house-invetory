package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Dispatch;
import com.ware.util.HibernateUtil;

public class DispatchDAO {

    public void save(Dispatch d) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(d);
        tx.commit();
        s.close();
    }
}
