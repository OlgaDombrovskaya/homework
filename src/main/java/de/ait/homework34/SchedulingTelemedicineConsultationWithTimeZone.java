package de.ait.homework34;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SchedulingTelemedicineConsultationWithTimeZone {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        // Ввод времени консультации врача
        System.out.print("Время консультации для врача (dd.MM.yyyy HH:mm): \n");
        String inputDate = scanner.nextLine();

        // Ввод часового пояса врача
        System.out.print("Часовой пояс врача (например, Europe/Berlin): ");
        String doctorTimezone = scanner.nextLine();

        // Ввод часового пояса пациента
        System.out.print("Часовой пояс пациента (например, America/New_York): ");
        String patientTimezone = scanner.nextLine();

        // Преобразуем строку в дату и время врача в его часовом поясе
        ZonedDateTime doctorTime = ZonedDateTime.of(LocalDateTime.parse(inputDate, formatter), ZoneId.of(doctorTimezone));

        // Переводим в часовой пояс пациента
        ZonedDateTime patientTime = doctorTime.withZoneSameInstant(ZoneId.of(patientTimezone));

        // Вывод результата
        System.out.println("Время консультации для врача: " + doctorTime.format(formatter) + " (" + doctorTimezone + ")");
        System.out.println("Время консультации для пациента: " + patientTime.format(formatter) + " (" + patientTimezone + ")");
    }
}