package de.ait.homework34;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculateAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
    }
}
