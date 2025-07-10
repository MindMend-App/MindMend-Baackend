// src/main/java/com/Mindmend/mindmend/dto/ChatRequest.java
package com.Mindmend.mindmend.dto;

import java.util.List;

public class ChatRequest {
    private String message;
    private List<String> history;

    public String getMessage() {
        return message;
    }
    public void setMessage(String m) { this.message = m; }

    public List<String> getHistory() {
        return history;
    }
    public void setHistory(List<String> h) { this.history = h; }
}
