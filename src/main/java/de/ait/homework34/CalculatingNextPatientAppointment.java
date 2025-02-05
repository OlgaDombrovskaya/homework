package de.ait.homework34;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculatingNextPatientAppointment {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату последнего визита (dd.MM.yyyy): \n");
        String inputDate = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate lastVisit = LocalDate.parse(inputDate, formatter);

        // Рассчитываем дату следующего визита через 6 месяцев
        LocalDate nextVisit = lastVisit.plusMonths(6);

        // Проверяем, если дата попала на выходной день, переносим на понедельник
        if (nextVisit.getDayOfWeek() == DayOfWeek.SATURDAY) {
            nextVisit = nextVisit.plusDays(2); // Перенос на понедельник
        } else if (nextVisit.getDayOfWeek() == DayOfWeek.SUNDAY) {
            nextVisit = nextVisit.plusDays(1); // Перенос на понедельник
        }
        // Выводим результат
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        System.out.println("Дата следующего визита: " + nextVisit.format(outputFormatter) + " (перенесено с выходного)");
    }
}
