package de.ait.homework39;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

@Slf4j
public class StoreDeserializator {
    public static void main(String[] args) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("products.dat"))) {
            List<Product> resultProducts = (List<Product>) objectInputStream.readObject();
            for (Product product : resultProducts) {
                System.out.println(product);
            }
        } catch (IOException exception) {
            log.error("Ошибка при чтении файла");
        } catch (ClassNotFoundException exception) {
            log.error("Класс не найден");
        }
    }
}

