package de.ait.homework43;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/*Форматирование даты и времени

Возьмите текущий LocalDateTime.
Сформатируйте его в строку вида dd-MM-yyyy HH:mm:ss.
Выведите результат в консоль.*/

public class DateTimeFormatterExample {
    public static void main(String[] args) {
        // Получаем текущую дату и время
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Создаем форматтер для нужного формата
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Форматируем текущую дату и время в строку
        String formattedDateTime = currentDateTime.format(formatter);

        // Выводим результат в консоль
        System.out.println("Отформатированная дата и время: " + formattedDateTime);
    }
}