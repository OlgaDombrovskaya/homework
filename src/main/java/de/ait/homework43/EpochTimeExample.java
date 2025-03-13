package de.ait.homework43;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/*
Работа с эпохой (Epoch)

Создайте Instant, соответствующий текущему моменту.
Выведите количество миллисекунд (или секунд) с начала эпохи (1970-01-01T00:00:00Z).
Преобразуйте этот Instant обратно в LocalDateTime в локальном часовом поясе.
 */
public class EpochTimeExample {
    public static void main(String[] args) {
        Instant instant = Instant.now();

        // Получаем количество секунд с начала эпохи
        long secondsSinceEpoch = instant.getEpochSecond();
        System.out.println("Количество секунд с начала эпохи: " + secondsSinceEpoch);

        // Получаем количество миллисекунд с начала эпохи
        long millisSinceEpoch = instant.toEpochMilli();
        System.out.println("Количество миллисекунд с начала эпохи: " + millisSinceEpoch);

        // Преобразуем Instant обратно в LocalDateTime в локальном часовом поясе
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("Дата и время в локальном часовом поясе: " + localDateTime);
    }
}
