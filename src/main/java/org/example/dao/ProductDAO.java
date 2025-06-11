package org.example.dao;

import org.example.DB_Util;
import org.example.domain.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

/**
 * DAO для работы с сущностью Product
 * Предоставляет методы для создания, получения, обновления и удаления товаров с использованием Hibernate
 */
public class ProductDAO {

    SessionFactory sessionFactory = DB_Util.getSessionFactory();
    /**
     * Создаёт новый продукт в базе данных
     * Если товар с таким именем уже существует, его количество увеличивается на 1
     * В противном случае создаётся новый товар с количеством 1
     */
    public void create(Product product) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            Product existingProduct = findByName(product.getName());
            if (existingProduct != null) {
                existingProduct.setQuantity(existingProduct.getQuantity() + 1);
                session.update(existingProduct);
            } else {
                product.setQuantity(1);
                session.persist(product);
            }
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
            session.merge(product);
        }
    }

    public void delete(Product product) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            session.remove(product);
        }
    }

    public Product getById(long id) {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            return session.get(Product.class, id);
        }
    }

    public Product findByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("From Product WHERE name = :name", Product.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }
}
