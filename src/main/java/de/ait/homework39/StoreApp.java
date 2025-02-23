package de.ait.homework39;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class StoreApp {


    private static List<Product> products = new ArrayList<>();
    private static final String FILE_NAME = "products.dat";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
           // Меню
            System.out.println("1. Добавить товар");
            System.out.println("2. Посмотреть все товары");
            System.out.println("3. Сохранить товары в файл");
            System.out.println("4. Загрузить товары из файла");
            System.out.println("5. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    viewProducts();
                    break;
                case 3:
                    saveProductsToFile();
                    break;
                case 4:
                    loadProductsFromFile();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
            }
        }
    }


    // Добавление нового товара
    private static void addProduct(Scanner scanner) {
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();

        System.out.print("Введите цену товара: ");
        double price = scanner.nextDouble();

        System.out.print("Введите количество товара: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Введите промо-код товара(оставьте пустым, если нет): ");
        String promoCode = scanner.nextLine();
        if (promoCode.isEmpty()) {
            promoCode = null; // Если промо-код не введен, устанавливаем его как null
        }
        System.out.print("Введите категорию товара: ");
        String category = scanner.nextLine();

        System.out.print("Введите описание товара: ");
        String description = scanner.nextLine();

        Product product = new Product(name, price, quantity, promoCode, category, description);
        products.add(product);
        System.out.println("Товар добавлен.");
    }

    // Просмотр всех товаров
    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("Список товаров пуст.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    // Сохранение товаров в файл
    private static void saveProductsToFile() {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            System.out.println("Сохраняемые товары:");
            for (Product product : products) {
                System.out.println(product);  // Выводим товары перед сохранением
            }
            objectOutputStream.writeObject(products);
            System.out.println("Товары успешно сохранены в файл.");
        } catch (IOException exception) {
            log.error("Ошибка при записи в файл");
        }
    }

    // Считывание товаров из файла
    private static void loadProductsFromFile() {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<Product> loadedProducts = (List<Product>) objectInputStream.readObject();
            products.clear();
            products.addAll(loadedProducts);
            System.out.println("Товары успешно считаны из файла.");

            // Выводим считанные товары
            System.out.println("Считанные товары:");
            for (Product product : loadedProducts) {
                System.out.println(product);  // Выводим считанные товары
            }

        } catch (IOException exception) {
            log.error("Ошибка при чтении файла");
        } catch (ClassNotFoundException exception) {
            log.error("Класс не найден");
        }
    }
}

