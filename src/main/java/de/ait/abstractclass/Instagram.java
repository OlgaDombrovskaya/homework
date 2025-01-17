package de.ait.abstractclass;

/**
 * Класс Instagram расширяет абстрактный класс SocialMedia, представляя аккаунт на Instagram. Он обеспечивает функцию публикации контента на платформе Instagram.
 */
public class Instagram extends SocialMedia {
    /**
     * Создаёт инстанцию Instagram с указанным именем пользователя.
     * @param userName имя пользователя
     */
    public Instagram(String userName) {
        super(userName);
    }
    /**
     * Публикует контент на Instagram.
     * @param content контент, который будет опубликован
     */
    @Override
    public void postContent(String content) {
        System.out.println(getUserName() + " posted: " + content + " on Instagram");
    }
}