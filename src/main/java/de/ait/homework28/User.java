package de.ait.homework28;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class User {
    private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
    protected String id;
    protected String name;
    protected String email;
    protected ArrayList<User> friends;
    protected ArrayList<Post> posts;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.friends = new ArrayList<>();
        this.posts = new ArrayList<>();
    }
    // Добавляем геттер для получения имени пользователя
    public String getName() {
        return name;
    }

    public void printInfo(){
        System.out.println("Id: " + id + ", Name: " + name + ", Email: " + email);
        LOGGER.info("Выведена информация о пользователе: " + name);
    }
    // Метод для добавления друга
    public void addFriend(User user) {
        if (!friends.contains(user) && !id.equals(user.id)) { // Исключаем самого себя
            friends.add(user);
            System.out.println(user.name + " теперь ваш друг.");
            LOGGER.info(name + " добавил(а) в друзья " + user.getName());
        } else if (id.equals(user.id)) {
            System.out.println("Вы не можете добавить себя в друзья.");
            LOGGER.warn(name + " попытался(ась) добавить себя в друзья.");
        } else {
            System.out.println(user.name + " уже является вашим другом.");
            LOGGER.info(user.getName() + " уже в списке друзей " + name);
        }

    }

    // Метод для удаления друга
    public void removeFriend(User user) {
        if (friends.contains(user)) {
            friends.remove(user);
            System.out.println(user.name + " больше не ваш друг.");
        } else {
            System.out.println(user.name + " не находится в списке ваших друзей.");
        }
    }

    // Метод для создания поста
    public Post createPost(String content, User author) {
        Post post = new Post(author, content);
        posts.add(post);
        LOGGER.info(name + " создал(а) новый пост: " + content);
        return post;
    }

    // Метод для просмотра постов всех друзей
    public void viewFriendsPosts() {
        if (friends.isEmpty()) {
            System.out.println("У вас нет больше друзей для просмотра.");
            LOGGER.warn(name + " попытался(ась) просмотреть посты друзей, но у него/неё нет друзей.");
            return;
        }

        System.out.println("-------------------------");
        boolean hasPosts = false;

        for (User friend : friends) {
            System.out.println(friend.name + " написал(а) следующие посты:");

            if (friend.posts.isEmpty()) {
                System.out.println("У этого друга нет постов.");
                LOGGER.info(friend.getName() + " не имеет постов.");
            } else {
                for (Post post : friend.posts) {
                    post.printPost(); // Выводим информацию о постах
                }
                hasPosts = true;
            }
        }
        //Если у всех друзей нет постов
        if (!hasPosts) {
            System.out.println("У всех ваших друзей нет постов.");
        }
    }
}