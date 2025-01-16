package de.ait.interfaces;

/**
 * Этот интерфейс определяет контракт для публикации контента в социальных сетях.
 * Он предоставляет метод для размещения сообщений.
 */
public interface SocialSharing {

    /**
     * Публикует сообщение на платформе социальной сети.
     *
     * @param message The message to post. / Сообщение для публикации.
     */
    void postMessage(String message);
}