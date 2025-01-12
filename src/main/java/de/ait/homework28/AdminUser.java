package de.ait.homework28;

import java.util.ArrayList;
import java.util.List;

public class AdminUser extends User {

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
    }

    // Метод для проверки заблокирован ли пользователь
    // public boolean isBanned(User user) {
    //   return bannedUsers.contains(user);
    // }
}
