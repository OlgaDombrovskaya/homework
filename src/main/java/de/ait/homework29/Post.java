package de.ait.homework29;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
@Slf4j

public class Post implements Likable, Commentable{
    private int likesCount; // Количество лайков
    private List<String> comments;// Список комментариев

    public Post() {
        this.likesCount = 0;
        this.comments = new ArrayList<>();
    }
    // Реализация метода addComment() из интерфейса Commentable
    @Override
    public void addComment(String comment) {
        if(comment == null || comment.isEmpty()){
            System.out.println("Comment is empty or null");
            log.warn("Comment is empty or null");
        }else {
            comments.add(comment);// Добавляем комментарий в список
       System.out.println("Comment added: " +comment);
            log.info("Comment added: {}", comment);
        }
    }
    // Реализация метода getComments() из интерфейса Commentable
    @Override
    public List<String> getComments() {
        return new ArrayList<>(comments); // Возвращаем список комментариев на новом листе
    }
    // Реализация метода like() из интерфейса Likable

    @Override
    public void like() {
        likesCount++;//Увеличиваем количество лайков

    }
    // Реализация метода getLikesCount() из интерфейса Likable
    @Override
    public int getLikesCount() {
        return likesCount;// Возвращаем количество лайков
    }

    // 2 ВАРИАНТ : Отображает подробную информацию о сообщении, включая лайки и комментарии.

    public void getInfoAboutPost() {
        System.out.println("---------Post info--------------");
        log.info("Post info");
        System.out.println("Likes count: " + likesCount);
        log.info("Likes count: {}", likesCount);
        System.out.println("Comments: " + comments);
        log.info("Comments: {}", comments);
    }

}
