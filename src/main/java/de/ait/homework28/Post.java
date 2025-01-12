package de.ait.homework28;

public class Post {
    private User author;  // Автор поста
    private String content; // Текст записи
    private int likes;  // Количество лайков

    // Конструктор для создания поста
    public Post(User author, String content) {
        this.author = author;
        this.content = content;
        this.likes = 0;
    }

    // Метод для увеличения количества лайков
    public void like() {
        likes++;
    }

    // Метод для вывода информации о посте
    public void printPost() {
        System.out.println("Автор: " + author.name);
        System.out.println("Контент: " + content);
        System.out.println("Лайков: " + likes);
        System.out.println("-------------------------");
    }
}