package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Supplier;
import com.ware.util.HibernateUtil;

public class SupplierDAO {

    public void save(Supplier s) {   // renamed from saveSupplier to save
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(s);

        tx.commit();
        session.close();
    }
}
