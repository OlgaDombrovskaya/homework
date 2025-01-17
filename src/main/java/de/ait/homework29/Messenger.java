package de.ait.homework29;

import java.util.List;

public interface Messenger {
    void sendMessage(String message, String userId);
    List<String> receiveMessages(String userId);
}
