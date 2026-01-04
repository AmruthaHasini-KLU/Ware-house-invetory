package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Warehouse;
import com.ware.util.HibernateUtil;

public class WarehouseDAO {

    public void save(Warehouse w) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(w);
        tx.commit();
        s.close();
    }

    public Warehouse getById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Warehouse w = s.get(Warehouse.class, id);
        s.close();
        return w;
    }

    public void update(Warehouse w) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.update(w);
        tx.commit();
        s.close();
    }

    public void delete(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Warehouse w = s.get(Warehouse.class, id);
        if (w != null) {
            s.delete(w);
        }
        tx.commit();
        s.close();
    }
}
