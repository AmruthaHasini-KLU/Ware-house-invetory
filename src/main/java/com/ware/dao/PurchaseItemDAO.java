package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.PurchaseItem;
import com.ware.util.HibernateUtil;

public class PurchaseItemDAO {

    public void save(PurchaseItem pi) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(pi);
        tx.commit();
        s.close();
    }
}
