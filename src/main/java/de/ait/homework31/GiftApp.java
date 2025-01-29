package de.ait.homework31;

import de.ait.exceptions.WrongCategoryException;

import java.util.List;
import java.util.Scanner;

public class GiftApp {
    private static GiftManager giftManager = new GiftManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Выводим приветствие и меню один раз в начале программы
        System.out.println("Добро пожаловать в систему управления подарками!");
        printMenu();

        while (true) {
            System.out.print("Выберите действие: ");
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    try {
                    addGift();  // Добавить подарок
                    } catch (WrongCategoryException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                    break;
                case 2:
                    showAllGifts();  // Показать все подарки
                    break;
                case 3:
                    filterGiftsByCategory();  // Фильтровать подарки по категории
                    break;
                case 4:
                    updateGiftStatus();  // Обновить статус подарка
                    break;
                case 5:
                    System.out.println("Выход из программы. Спасибо за использование!");
                    scanner.close();
                    return; // Выход из программы

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    printMenu();
            }
        }
    }
    // Метод для печати меню
    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 - Добавить подарок");
        System.out.println("2 - Показать все подарки");
        System.out.println("3 - Фильтровать подарки по категории");
        System.out.println("4 - Обновить статус подарка");
        System.out.println("5 - Выход");
    }

    // Получение выбора пользователя с проверкой
    private static int getUserChoice() {
        int choice = 0; // задаем переменную с числовым значением
        boolean valid = false; // Переменная для проверки корректности ввода

        while (!valid) {
            choice = scanner.nextInt(); // Считываем целое число

            // Проверка, что число в пределах от 1 до 5
            if (choice >= 1 && choice <= 5) {
                valid = true; // Число корректное, выходим из цикла
            } else {
                System.out.println("Ошибка: выберите число от 1 до 5.");
            }
        }
        scanner.nextLine(); // Очистка буфера
        return choice; // Возвращаем корректное число
    }


      // Добавление нового подарка
    private static void addGift()throws WrongCategoryException {
        System.out.print("Введите название подарка: ");
        String name = scanner.nextLine().trim();

        System.out.println("Выберите категорию (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
        GiftCategory category = getGiftCategory();

        System.out.println("Выберите статус (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");
        GiftStatus status = getGiftStatus();

        Gift gift = new Gift(name, category, status);
        giftManager.addGift(gift);  // Добавление подарка
        System.out.println("Подарок добавлен!");
    }

    // Метод для получения категории подарка
    private static GiftCategory getGiftCategory() {
        while (true) {
            String input = scanner.nextLine().toUpperCase();  // Преобразуем ввод заглавными буквами
                try {
                    return GiftCategory.valueOf(input);  // Используем метод valueOf для enum
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверный ввод. Попробуйте снова.");
                }
            }
    }

    // Метод для получения статуса подарка
    private static GiftStatus getGiftStatus() {
            while (true) {
                String input = scanner.nextLine().toUpperCase();
                try {
                    return GiftStatus.valueOf(input);  // Используем метод valueOf для enum
                } catch (IllegalArgumentException e) {
                    System.out.println("Неверный ввод. Попробуйте снова.");
                }
            }
    }

    // Показ всех подарков
    private static void showAllGifts() {
        List<Gift> gifts = giftManager.getAllGifts();
        if (gifts.isEmpty()) {
            System.out.println("Нет доступных подарков.");
        } else {
            System.out.println("Список всех подарков:");
            for (Gift gift : gifts) {
                System.out.println(gift.getName() + ", Категория: " + gift.getCategory() + ", Статус: " + gift.getStatus());
            }
        }
    }

    // Фильтрация подарков по категории
    private static void filterGiftsByCategory() {
        System.out.println("Введите категорию для фильтрации (ELECTRONICS, TOYS, BOOKS, CLOTHING, HOME_APPLIANCES): ");
        GiftCategory category = getGiftCategory();

        List<Gift> filteredGifts = giftManager.filterByCategory(category);
        if (filteredGifts.isEmpty()) {
            System.out.println("Нет подарков в этой категории.");
        } else {
            System.out.println("Результаты фильтрации:");
            int index = 1;
            for (Gift gift : filteredGifts) {
                System.out.println(index + ". " + gift.getName() + ", Статус: " + gift.getStatus());
                index++; // Увеличиваем индекс
            }
        }
    }

    // Обновление статуса подарка
    private static void updateGiftStatus() {
        System.out.print("Введите название подарка, чтобы обновить его статус: ");
        String name = scanner.nextLine().trim();

        Gift gift = giftManager.getGiftByName(name);
        if (gift == null) {
            System.out.println("Подарок с таким именем не найден.");
            return;
        }

        System.out.println("Выберите новый статус (AVAILABLE, OUT_OF_STOCK, RESERVED, DELIVERED): ");

        GiftStatus newStatus = getGiftStatus();
        giftManager.updateGiftStatus(name, newStatus);

        System.out.println("Статус подарка обновлен!");
    }
}
