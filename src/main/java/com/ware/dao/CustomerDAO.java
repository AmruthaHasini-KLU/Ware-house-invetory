package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Customer;
import com.ware.util.HibernateUtil;

public class CustomerDAO {

    public void save(Customer c) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(c);
        tx.commit();
        s.close();
    }
}
