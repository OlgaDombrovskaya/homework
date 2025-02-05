package de.ait.timeapi;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeBetweenVisits {
    public static void main(String[] args) {
        // Время первого визита
        LocalDateTime firstVisit = LocalDateTime.of(2025, 2, 1, 9, 30); // 1 февраля 2025 года, 9:30
        // Время второго визита
        LocalDateTime secondVisit = LocalDateTime.of(2025, 2, 4, 14, 45); // 4 февраля 2025 года, 14:45

        // Вычисление разницы между визитами
        Duration duration = Duration.between(firstVisit, secondVisit);

        // Форматированный вывод
        System.out.println("Время между визитами в днях:" + duration.toDays());
        System.out.println("Время между визитами в часах:" + duration.toHours());

        // Получаем количество дней, часов и минут
       // long days = duration.toDays();
       // long hours = duration.toHours() % 24;  // остаток часов после целых дней
       // long minutes = duration.toMinutes() % 60;  // остаток минут после целых часов
        // Форматированный вывод
       // System.out.println("Время между визитами:");
       // System.out.printf("%d дней, %d часов, %d минут%n", days, hours, minutes);
    }
}
