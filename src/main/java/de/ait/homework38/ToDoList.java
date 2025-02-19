package de.ait.homework38;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ToDoList {
    public static void main(String[] args) {
        String filePath = "tasks.txt"; // Путь к файлу, который будет читаться
        // Чтение задач из файла и вывод на консоль
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) { // Используем BufferedReader для чтения построчно
                int data; // Переменная для хранения прочитанного символа
            while ((data = reader.read()) != -1) { // Чтение файла построчно
                System.out.print( (char) data);; // Вывод строки в консоль
            }
        reader.close(); // Закрываем поток
        }
        catch (FileNotFoundException exception) { // Обработка исключения, если файл не найден
            System.out.println("File not found");
            exception.printStackTrace();
        } catch (IOException exception) { // Обработка исключения при ошибке чтения
            System.out.println("Error reading from file");
            exception.printStackTrace();
        }
    }
}