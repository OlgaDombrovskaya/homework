package de.ait.homework29;

public class MainLikes {
    public static void main(String[] args) {
        // Создаём объект поста с максимальным количеством комментариев, например 5
        Post post = new Post();

        // Поставим несколько лайков
        post.like();
        post.like();

        // Добавим несколько комментариев
        post.addComment("Это отличный пост!");
        post.addComment("Мне очень понравился ваш пост!");

        // Выведем количество лайков и комментарии
        System.out.println("Количество лайков: " + post.getLikesCount());
        System.out.println("Комментарии:");
        for (String comment : post.getComments()) {
            System.out.println(comment);
        }

        post.getInfoAboutPost();  // 2 ВАРИАНТ

        System.out.println("--------------------------");

        Post postMusic = new Post(); // "кривой пост"
        postMusic.like(); // поставим лайк
        postMusic.addComment(null);//добавим коммент
        postMusic.getInfoAboutPost();//выведем информацию

    }
}
