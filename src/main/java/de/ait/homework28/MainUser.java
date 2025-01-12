package de.ait.homework28;

public class MainUser {
    public static void main(String[] args) {
        // Работа с экземпляром класса User (обычный пользователь)
        User regularUser = new User("1AA", "John", "john@gmail.com");
        regularUser.printInfo();

        PremiumUser premiumUser = new PremiumUser("2BB", "Alice", "alice@uralweb.ru", 2024);
        premiumUser.printInfo(); // Вывод информации о премиум-пользователе
        System.out.println("Активна ли подписка у Alice? " + premiumUser.isSubscriptionActive()); // Проверка активности подписки

        AdminUser adminUser = new AdminUser("3CC", "Bob", "bob@yahoo.com");
        adminUser.printInfo(); // Вывод информации о администраторе
        adminUser.banUser(regularUser); // Блокировка пользователя
        // System.out.println("Заблокирован ли John? " + adminUser.isBanned(regularUser)); // Проверка, заблокирован ли John

        // Вызываем методы для разных типов пользователей с использованием полиморфизма
        User anyUser = new PremiumUser("4DD", " Maria", " maria@example.com ", 2025);// Создаём объект типа PremiumUser, но с типом User
        anyUser.printInfo(); // Вызов метода printInfo из User
        // Вызов метода isSubscriptionActive() будет работать корректно, так как это метод в классе PremiumUser
        PremiumUser premium = (PremiumUser) anyUser; // Приведение типа
        System.out.println("Активна ли подписка у Maria? " + premium.isSubscriptionActive()); // Проверка активности подписки

        anyUser = new AdminUser("5", "Olga", "olga@gmail.com");
        anyUser.printInfo(); // Вызов метода printInfo из User, который будет переопределён в AdminUser

        regularUser.addFriend(premiumUser);
        regularUser.addFriend(adminUser);

        // Создание постов у друзей
        Post post1 = adminUser.createPost("Привет, друзья!", adminUser);
        Post post2 = premiumUser.createPost("Как дела у всех?", premiumUser);

        post1.like();  // Увеличиваем лайк
        post2.like();  // Увеличиваем лайк
        post2.like();  // Увеличиваем лайк

        // Просмотр постов друзей обычным пользователем
        regularUser.viewFriendsPosts(); // John просматривает посты своих друзей

        // Создание постов пользователем, который является премиум-пользователем
        Post premiumPost = premiumUser.createPost("Это эксклюзивный пост для премиум-пользователей.", premiumUser);
        premiumPost.like(); // Поставим лайк на пост

        // Просмотр постов друзей для премиум пользователя
        premiumUser.viewFriendsPosts(); // Alice просматривает посты своих друзей
    }
}