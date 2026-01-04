package com.ware.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.ware.entity.Product;
import com.ware.util.HibernateUtil;

public class ProductDAO {

    public void save(Product p) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        s.save(p);
        tx.commit();
        s.close();
    }

    public void deactivate(int productId) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = s.beginTransaction();
        Product p = s.get(Product.class, productId);
        if (p != null) {
            p.setStatus("INACTIVE");
            s.update(p);
        }
        tx.commit();
        s.close();
    }
}
