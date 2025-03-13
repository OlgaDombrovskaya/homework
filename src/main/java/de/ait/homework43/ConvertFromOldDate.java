package de.ait.homework43;
/*Конвертация из старого класса Date

Создайте объект Date (из пакета java.util).
Переведите его в Instant, а затем в LocalDateTime (используя системный часовой пояс).
Выведите результат в консоль.*/

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ConvertFromOldDate {
    public static void main(String[] args) {
        Date date = new Date();

        Instant instant = date.toInstant(); /*Instant — это класс в пакете java.time,
         который представляет собой точку во времени на шкале времени, основанной
         на UTC (всемирное координированное время). Это объект, который описывает
         момент времени с точностью до наносекунд, но не содержит информации о часовом поясе.*/

        // Переводим Instant в LocalDateTime, используя системный часовой пояс
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Выводим результат
        System.out.println("Конвертированное время: " + localDateTime);
    }
}