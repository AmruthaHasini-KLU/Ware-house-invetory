package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Bin;
import com.ware.util.HibernateUtil;

public class BinDAO {

    public void save(Bin b) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(b);
        tx.commit();
        s.close();
    }
}
