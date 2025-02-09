package de.ait.homework34;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalculatingTimeRemainingUntilSurgery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

        // Ввод даты и времени операции в try-catch
        LocalDateTime operationTime = null;
        try {
            System.out.print("Дата и время операции (dd.MM.yyyy HH:mm): \n");
            String inputDate = scanner.nextLine();
            operationTime = LocalDateTime.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка: Неправильный формат даты и времени. Пожалуйста, используйте формат dd.MM.yyyy HH:mm.");
            return;  // Завершаем выполнение программы, если формат неверный
        }
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Если операция уже прошла, выводим предупреждение
        if (currentDateTime.isAfter(operationTime)) {
            System.out.println("Операция уже прошла.");
            return;
        }

        // Вычисление разницы между визитами
        Duration duration = Duration.between(currentDateTime, operationTime);

        // Выводим результат
        // Форматированный вывод
        System.out.println("До операции осталось: " + duration.toDays() + " дней "
                + duration.toHours() % 24 + " часов " + duration.toMinutes() % 60 + " минут");

        scanner.close();
    }
}
