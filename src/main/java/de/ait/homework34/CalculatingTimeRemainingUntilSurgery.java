package de.ait.homework34;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculatingTimeRemainingUntilSurgery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        System.out.print("Дата и время операции (dd.MM.yyyy HH:mm): \n");
        String inputDate = scanner.nextLine();

        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime operationTime = LocalDateTime.parse(inputDate, formatter);

        // Если операция уже прошла, выводим предупреждение
        if (currentDateTime.isAfter(operationTime)) {
            System.out.println("Операция уже прошла.");
            return;
        }

        // Вычисление разницы между визитами
        Duration duration = Duration.between(currentDateTime, operationTime);

        // Выводим результат
        // Форматированный вывод
        System.out.println("До операции осталось в днях:" + duration.toDays());
        System.out.println("До операции осталось в часах:" + duration.toHours());
        System.out.println("До операции осталось в минутах:" + duration.toMinutes());
    }
}
