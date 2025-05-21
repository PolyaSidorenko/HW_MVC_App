package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDAO {

    public void create(Product product) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
        }
    }

    public List<Product> getAll() {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            return session.createQuery("from Product", Product.class).list();
        }
    }

    public void update(Product product) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }
    }

    public void delete(Product product) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }
    }

    public Product getById(long id) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }
}
