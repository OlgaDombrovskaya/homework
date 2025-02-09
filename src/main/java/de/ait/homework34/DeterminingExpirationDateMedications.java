package de.ait.homework34;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DeterminingExpirationDateMedications {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            // Ввод даты производства
            System.out.print("Введите дату производства лекарства(dd.MM.yyyy): \n");
            String inputManufactureDate = scanner.nextLine();

            // Ввод срока хранения в месяцах
            System.out.print("Введите срок хранения лекарства в месяцах (MM): \n");
            int inputShelfLife = scanner.nextInt();

            // Проверка на корректность срока хранения
            if (inputShelfLife <= 0) {
                throw new IllegalArgumentException("Срок хранения должен быть положительным числом.");
            }

            // Если срок хранения больше 23 месяцев
            if (inputShelfLife > 99) {
                throw new IllegalArgumentException("Срок хранения не может превышать 99 месяцев.");
            }
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
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: Неправильный формат даты. Используйте формат dd.MM.yyyy.");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}