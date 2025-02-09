package de.ait.homework34;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalculateAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        try {
            // Ввод даты рождения пациента
            System.out.print("Введите дату рождения пациента (dd.MM.yyyy): \n");
            String inputBirthDate = scanner.nextLine();

            // Преобразуем строку в LocalDate
            LocalDate birthDate = LocalDate.parse(inputBirthDate, formatter);

            // Текущая дата
            LocalDate currentDate = LocalDate.now();

            // Вычисляем возраст
            Period age = Period.between(birthDate, currentDate);

            // Выводим возраст
            System.out.println("Возраст пациента: " + age.getYears() + " лет, " + age.getMonths() + " месяцев, " + age.getDays() + " дней.");
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: Неправильный формат даты и времени. Пожалуйста, используйте формат dd.MM.yyyy");
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
