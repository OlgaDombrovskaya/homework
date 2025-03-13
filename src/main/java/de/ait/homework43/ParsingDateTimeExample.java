package de.ait.homework43;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
/*Парсинг даты и времени из строки

Считайте с консоли строку формата yyyy-MM-dd HH:mm.
Преобразуйте её в объект LocalDateTime.
Выведите результат в консоль.*/

public class ParsingDateTimeExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату и время (формат yyyy-MM-dd HH:mm): ");
        String input = scanner.nextLine();
        // Создаем форматтер для нужного формата
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Парсим строку в объект LocalDateTime
        LocalDateTime parsedDateTime = LocalDateTime.parse(input, formatter);

        // Выводим результат
        System.out.println("Парсинг завершен. Результат: " + parsedDateTime);
    }
}
