package de.ait.homework39;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class StoreVariant2 {
    public static void main(String[] args) {


        Product product1 = new Product("Pumpkin", 4.00, 50, "P3V7K9J");
        Product product2 = new Product("Artichoke", 2.60, 76, "R1J3B8K");
        Product product3 = new Product("Peppers", 2.12, 20, "A6M5Q2E");
        Product product4 = new Product("Zucchini", 2.40, 100, "B4R8L9D");
        Product product5 = new Product("Asian Greens", 1.35, 12, "L9F6W3H");


        List<Product> products = new ArrayList<>();

       products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        String fileName = "products.dat";

        saveProducts(products, fileName);

        loadProducts(fileName);
    }

    private static void saveProducts(List<Product> products, String fileName) {
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            objectOutputStream.writeObject(products);
            System.out.println("Файл успешно записан: " + fileName);
            log.info("Файл успешно записан: {}", fileName);
        }
        catch (IOException exception){
            log.error("Файл не найден: {}", exception.getMessage());
        }
    }

    private static void loadProducts(String fileName) {
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))){
            List<Product> products = (List<Product>) objectInputStream.readObject();
            log.info("Loaded accounts from file: {}", fileName);
            for (Product product : products) {
                log.info("Account: {}", product);
            }
        }
        catch (IOException exception){
            log.error("File not found: {}", exception.getMessage());
        }
        catch (ClassNotFoundException exception){
            log.error("Class not found: {}", exception.getMessage());
        }
    }
}
