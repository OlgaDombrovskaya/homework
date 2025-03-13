package de.ait.homework43;
/*Операции сложения и вычитания времени

Создайте объект LocalDateTime для текущего момента.
Добавьте к нему 2 недели, вычтите 3 дня, прибавьте 5 часов.
Выведите получившийся результат в консоль.*/

import java.time.LocalDateTime;

public class TimePlusMinusExample {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();

        // Добавляем 2 недели, вычитаем 3 дня, прибавляем 5 часов
        LocalDateTime result = currentTime.plusWeeks(2).minusDays(3).plusHours(5);

        // Выводим результат
        System.out.println("Результат: " + result);
    }
}
