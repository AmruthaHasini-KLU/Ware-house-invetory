package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Supplier;
import com.ware.util.HibernateUtil;

public class SupplierDAO {

    public void save(Supplier s1) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(s1);
        tx.commit();
        s.close();
    }
}
