package de.ait.homework34;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DeterminingExpirationDateMedications {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        // Ввод даты производства
        System.out.print("Введите дату производства лекарства(dd.MM.yyyy): \n");
        String inputManufactureDate = scanner.nextLine();

        // Ввод срока хранения в месяцах
        System.out.print("Введите срок хранения лекарства в месяцах (MM): \n");
        int inputShelfLife = scanner.nextInt();

        // Преобразуем строку в LocalDate
        LocalDate manufactureDate = LocalDate.parse(inputManufactureDate, formatter);

        // Рассчитываем дату окончания срока годности
        LocalDate expirationDate = manufactureDate.plusMonths(inputShelfLife);

        // Получаем сегодняшнюю дату
        LocalDate currentDate = LocalDate.now();

        // Проверяем, просрочено ли лекарство
        String status;
        if (currentDate.isAfter(expirationDate)) { // если сегодняшняя дата позже даты окончания срока
            status = "ПРОСРОЧЕНО!";
        } else if (currentDate.isEqual(expirationDate)) { // если сегодняшняя дата равна дате окончания
            status = "ГОДНО! (Срок истёк сегодня)";
        } else {
            status = "ГОДНО!";
        }

        // Выводим результат
        System.out.println("Дата производства: " + manufactureDate.format(formatter));
        System.out.println("Срок хранения: " + inputShelfLife + " месяцев");
        System.out.println("Лекарство годно до: " + expirationDate.format(formatter));
        System.out.println("Статус: " + status);
    }
}
