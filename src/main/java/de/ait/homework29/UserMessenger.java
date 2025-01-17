package de.ait.homework29;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j

public class UserMessenger implements Messenger{

    private Map<String, List<String>> messagesMap;

    public UserMessenger() {
        messagesMap = new HashMap<>();
    }

    @Override
    public void sendMessage(String message, String userId) {// пользователь отправляет сообщение
        if (message == null || message.isEmpty() || userId == null || userId.isEmpty()) {
            System.out.println("Message or user is empty or null"); // уведомляем об этом
            log.warn("Message or user is empty or null");
        } else {
            System.out.println("User " + userId + " sent message: " + message);
            List<String> userMessages = this.messagesMap.get(userId);//по ключу получаем значение (через get передаем ключ в Map и получаем наш лист значение)
            if (userMessages == null) {
                userMessages = new ArrayList<>();
                userMessages.add(message); // добавляем наш лист значение
                this.messagesMap.put(userId, userMessages);// с сохраняем
                log.info("User {} sent message: {}", userId, message);
            } else {
                userMessages.add(message);
                this.messagesMap.put(userId, userMessages);
                log.info("User {} sent message: {}", userId, message);
            }
        }
    }

    @Override
    public List<String> receiveMessages(String userId) {
        List<String> userMessages = this.messagesMap.get(userId);// получаем список из Map
        return new ArrayList<>(userMessages);// возвращаем копию
    }
}