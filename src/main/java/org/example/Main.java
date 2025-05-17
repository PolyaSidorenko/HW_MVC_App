package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("Выберите действие: добавить товар; показать все товары; обновить товар; удалить товар. ");

            switch (scanner.nextLine()) {
                case "добавить товар" -> createProduct();
                case "показать все товары" -> showProducts();
                case "обновить товар" -> updateProduct();
                case "удалить товар" -> deleteProduct();
                default -> System.out.println("Неверный ввод.");
            }
        }
    }

    private static void createProduct() {
        System.out.print("Название: ");
        String name = scanner.nextLine();
        System.out.print("Цена: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Количество: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(new Product(null, name, price, quantity));
            transaction.commit();
        }
    }

    private static void showProducts() {
        try (Session session = DB_Util.getSessionFactory().openSession()) {
            List<Product> products = session.createQuery("from Product", Product.class).list();
            products.forEach(System.out::println);
        }
    }

    private static void updateProduct() {
        System.out.print("ID товара: ");
        long id = Long.parseLong(scanner.nextLine());

        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, id);
            if (product == null) {
                System.out.println("Товар не найден.");
                return;
            }

            System.out.print("Новое название: ");
            product.setName(scanner.nextLine());
            System.out.print("Новая цена: ");
            product.setPrice(Double.parseDouble(scanner.nextLine()));
            System.out.print("Новое количество: ");
            product.setQuantity(Integer.parseInt(scanner.nextLine()));

            Transaction tx = session.beginTransaction();
            session.merge(product);
            tx.commit();
        }
    }

    private static void deleteProduct() {
        System.out.print("ID товара: ");
        long id = Long.parseLong(scanner.nextLine());

        try (Session session = DB_Util.getSessionFactory().openSession()) {
            Product product = session.get(Product.class, id);
            Transaction transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        }
    }
}