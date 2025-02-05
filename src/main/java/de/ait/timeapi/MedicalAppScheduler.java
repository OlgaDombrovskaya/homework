package de.ait.timeapi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedicalAppScheduler {
    public static void main(String[] args) {

        // Время первого приёма лекарства
        LocalDateTime startTime = LocalDateTime.now();
        // Количество приёмов
        int numberOfDoses = 5;

        int intervalHours = 8;

        // Формат вывода времени
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Печать времени каждого приёма
        System.out.println("Время приёма лекарства:" + formatter.format(startTime));

        for (int i = 2; i < numberOfDoses + 1; i++) {
            LocalDateTime nextTime = startTime.plusHours(intervalHours);
            System.out.println(i + " --> " + formatter.format(nextTime));
            startTime = nextTime;
        }
    }
}

