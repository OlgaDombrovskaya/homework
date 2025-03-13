package de.ait.homework43;

import java.time.LocalDateTime;

/*
Проверка, прошло ли заданное время

Создайте LocalDateTime, который наступит через 2 часа от текущего момента.
Напишите небольшой цикл или метод, который будет каждые 10 секунд проверять, наступило ли это время.
Как только время наступит – выведите сообщение и завершите проверку.

 */
public class TimeCheckExample {
    public static void main(String[] args) {
        LocalDateTime futureTime = LocalDateTime.now().plusHours(2);

        System.out.println("Будущее время: " + futureTime);

        while (LocalDateTime.now().isBefore(futureTime)) {
            try {
                // Засыпаем на 10 секунд
                Thread.sleep(10000);  // 10 секунд

                // Печатаем сообщение о текущем времени для мониторинга
                System.out.println("Текущее время: " + LocalDateTime.now());

                // Периодическая проверка
                if (LocalDateTime.now().isAfter(futureTime)) {
                    System.out.println("Будущее наступило! " + futureTime);
                    break; // Завершаем цикл, если время наступило
                }
            } catch (InterruptedException e) {
                // Обрабатываем исключение InterruptedException
                System.out.println("Задача была прервана");
                Thread.currentThread().interrupt(); // Восстанавливаем статус прерывания
            }
        }
    }
}

