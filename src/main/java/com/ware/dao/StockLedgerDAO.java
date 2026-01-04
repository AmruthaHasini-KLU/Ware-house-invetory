package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.StockLedger;
import com.ware.util.HibernateUtil;

public class StockLedgerDAO {

    public void save(StockLedger sl) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(sl);
        tx.commit();
        s.close();
    }
}
