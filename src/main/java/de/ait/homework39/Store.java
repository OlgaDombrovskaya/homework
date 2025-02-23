package de.ait.homework39;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Store {
    public static void main(String[] args) {
        Faker faker = new Faker();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            products.add(new Product(faker.food().vegetable(), 2 + i, 50 + i, faker.code().asin()));
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("products.dat"))) {
            objectOutputStream.writeObject(products);
            System.out.println("Файл успешно записан");
        } catch (IOException exception) {
            log.error("Ошибка при записи в файл");
        }
    }
}
