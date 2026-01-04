package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.OrderItem;
import com.ware.util.HibernateUtil;

public class OrderItemDAO {

    public void save(OrderItem oi) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(oi);
        tx.commit();
        s.close();
    }
}
