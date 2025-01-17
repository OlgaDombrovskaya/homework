package de.ait.homework29;

import java.util.List;

public interface Commentable {

    void addComment(String comment);//добавляет комментарий.

    List<String> getComments();//возвращает список комментариев
}
