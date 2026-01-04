package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.PurchaseReceipt;
import com.ware.util.HibernateUtil;

public class PurchaseReceiptDAO {

    public void save(PurchaseReceipt pr) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(pr);
        tx.commit();
        s.close();
    }
}
