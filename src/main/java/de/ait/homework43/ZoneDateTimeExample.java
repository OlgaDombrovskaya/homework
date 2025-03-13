package de.ait.homework43;

/*Работа с часовыми поясами

Получите текущий ZonedDateTime для системной временной зоны.
Переведите это время в другой часовой пояс (например, ZoneId.of("America/New_York")).
Выведите оба результата.*/

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneDateTimeExample {
    public static void main(String[] args) {
        ZonedDateTime currentDateTime = ZonedDateTime.now();

        // Переводим текущее время в часовой пояс Нью-Йорка
        ZonedDateTime newYorkDateTime = currentDateTime.withZoneSameInstant(ZoneId.of("America/New_York"));

        System.out.println("Текущее время в системной временной зоне: " + currentDateTime);
        System.out.println("Текущее время в Нью-Йорке: " + newYorkDateTime);
    }
}
