package de.ait.homework29;

import java.util.List;

public class MainMesseges {
    public static void main(String[] args) {
        // Создаем объект UserMessenger, который будет управлять сообщениями
        UserMessenger userMessenger = new UserMessenger();

        // Отправляем сообщения разным пользователям
        userMessenger.sendMessage("Привет, как дела?", "user1");
        userMessenger.sendMessage("Привет! Как ты?", "user2");
        userMessenger.sendMessage("Есть новости?", "user1");
        userMessenger.sendMessage("Как погода?", "user2");

        // Получаем и выводим сообщения для user1
        System.out.println("Сообщения для user1:");
        for (String message : userMessenger.receiveMessages("user1")) {
            System.out.println(message);
        }

        // Получаем и выводим сообщения для user2
        System.out.println("Сообщения для user2:");
        for (String message : userMessenger.receiveMessages("user2")) {
            System.out.println(message);
        }

        // 2 ВАРИАНТ
        // Получение и отображение истории сообщений для пользователя 1
        List<String> userOneMessages = userMessenger.receiveMessages("1");
        System.out.println(userOneMessages);

        // Получение и отображение истории сообщений для пользователя 2
        List<String> userTwoMessages = userMessenger.receiveMessages("2");
        System.out.println(userTwoMessages);
    }
}
