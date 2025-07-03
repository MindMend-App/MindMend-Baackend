// src/main/java/com/Mindmend/mindmend/store/ConversationStore.java
package com.Mindmend.mindmend.store;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ConversationStore {

    private final List<String> userMessages = new ArrayList<>();
    private final List<String> botMessages  = new ArrayList<>();

    public void appendUserMessage(String msg) {
        userMessages.add(msg);
    }
    public void appendBotMessage(String msg) {
        botMessages.add(msg);
    }
    public List<String> getUserMessages() {
        return new ArrayList<>(userMessages);
    }
    public void clear() {
        userMessages.clear();
        botMessages.clear();
    }
}
