package de.ait.homework40;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class TravelReview {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Path path = Path.of("travel_review.txt");

        while (true) {System.out.println("Please enter your travel review(or type 'exit' to quit) :");
        String review = scanner.nextLine();

        // Если пользователь введет "exit", выходим из цикла
        if (review.equalsIgnoreCase("exit")) {
            System.out.println("Exiting. Thank you for your reviews!");
            break;
        }

        // Записываем отзыв в файл
        writeTravelReview(path, review);
    }
        // Читаем список из файла и сохраняем его в список travelReviews
        List<String> travelReviews = readTravelReviews(path);
        // Выводим все отзывы построчно
        System.out.println("\nTravel Reviews:");
        for (String line : travelReviews) {
            log.info(line);
        }
    }

    // Метод для записи отзыва в файл
    public static void writeTravelReview(Path path, String review) {
        try {
            // Записываем отзыв в файл, добавляя его в конец, если файл существует
            Files.writeString(path, review + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Your review has been saved!");
        } catch (IOException exception) {
            // Логируем ошибку, если произошла проблема с записью
            log.error("Error writing to file: {}", exception.getMessage());
        }
    }

    public static List<String> readTravelReviews(Path path) {
        List<String> travelReviews = new ArrayList<>();
        try {
            // Чтение всех строк из файла
            travelReviews = Files.readAllLines(path);
        } catch (IOException exception) {
            log.error("Error reading file: {}", exception.getMessage());
        }
        // Возвращаем список строк
        return travelReviews; // Просто возвращаем список, даже если он пустой
    }
}