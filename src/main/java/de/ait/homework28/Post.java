package de.ait.homework28;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Post {
    private static final Logger LOGGER = LoggerFactory.getLogger(Post.class);
    private User author;  // Автор поста
    private String content; // Текст записи
    private int likes;  // Количество лайков

    // Конструктор для создания поста
    public Post(User author, String content) {
        this.author = author;
        this.content = content;
        this.likes = 0;

        // Логируем создание нового поста
        LOGGER.info("Создан новый пост. Автор: " + author.getName() + ", Контент: " + content);
    }

    // Метод для увеличения количества лайков
    public void like() {
        likes++;
        LOGGER.info("Пост получил новый лайк. Лайков: " + likes);
    }

    // Метод для вывода информации о посте
    public void printPost() {
        System.out.println("Автор: " + author.name);
        System.out.println("Контент: " + content);
        System.out.println("Лайков: " + likes);
        System.out.println("-------------------------");
    }
}