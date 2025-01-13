package de.ait.homework28;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class AdminUser extends User {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminUser.class);
    private List<User> bannedUsers;

    public AdminUser(String id, String name, String email) {
        super(id, name, email);
        this.bannedUsers = new ArrayList<>();
    }

    @Override
    public void printInfo() {
        System.out.println("Id: " + id + ", Name: " + name +
                ", Email: " + email + ", Тип пользователя - Администратор");
    }

    public void banUser(User user) {
        bannedUsers.add(user);
        System.out.println("Пользователь " + user.name + "  заблокирован.");
        LOGGER.info("Администратор " + name + " заблокировал пользователя: " + user.getName());
    }

    // Метод для проверки заблокирован ли пользователь
    // public boolean isBanned(User user) {
    //   return bannedUsers.contains(user);
    // }
}
