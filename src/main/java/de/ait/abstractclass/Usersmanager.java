package de.ait.abstractclass;

import java.util.ArrayList;
import java.util.List;

public class Usersmanager {
    public static void main(String[] args) {

        // Создание списка для хранения пользователей
        List<User> users = new ArrayList<>();

        // Добавление пользователей в список
        users.add(new RegularUser("Max", 1));
        users.add(new AdminUser("John", 2));

        // Итерация по списку и выполнение специфичных действий пользователей
        for (User user : users) {
            user.performAction();
        }
    }
}

