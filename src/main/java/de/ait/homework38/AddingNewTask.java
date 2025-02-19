package de.ait.homework38;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddingNewTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя новую задачу
        System.out.print("Введите новую задачу: \n");
        String textToWrite = scanner.nextLine();

        // Путь к файлу, куда будем добавлять задачу
        String filePath = "tasks.txt";

        // Попробуем добавить задачу в файл
        try (FileWriter writer = new FileWriter(filePath, true)) { // true позволяет добавлять текст в файл, а не перезаписывать
            writer.write(textToWrite+ "\n"); // Записываем задачу
            writer.close(); // Закрываем поток
            System.out.print("Задача успешно добавлена!");

        } catch (IOException exception) {
            System.out.println("Ошибка при добавлении задачи в файл.");
            exception.printStackTrace();
        }
    }
}
