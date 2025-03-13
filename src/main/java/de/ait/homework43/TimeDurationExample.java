package de.ait.homework43;
/*Работа с интервалами времени (Duration)

Создайте два объекта LocalTime: начало рабочего дня (например, 09:00) и конец рабочего дня (например, 18:00).
Подсчитайте, сколько часов и минут между ними, используя Duration.
Выведите результат.*/

import java.time.Duration;
import java.time.LocalTime;

public class TimeDurationExample {
    public static void main(String[] args) {

        LocalTime endOfWork = LocalTime.of(18,0);
        LocalTime startOfWork = LocalTime.of(9,0);

        // Вычисляем продолжительность между двумя временем
        Duration duration = Duration.between(startOfWork, endOfWork);

        long hours = duration.toHours();  // Количество часов
        long minutes = duration.toMinutes() % 60;  // Количество минут (оставшиеся после часов)

        // Выводим результат
        System.out.println("Рабочий день длится: " + hours + " часов и " + minutes + " минут.");
    }
}