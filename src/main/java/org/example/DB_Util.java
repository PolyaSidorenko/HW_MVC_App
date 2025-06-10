package org.example;

import lombok.Getter;
import org.example.domain.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Класс для создания и получения SessionFactory
 * Инициализирует фабрику сессий один раз при загрузке класса используя файл hibernate.cfg.xml
 * и сущность Product
 */
public class DB_Util {
    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.addAnnotatedClass(Product.class);

            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

}
