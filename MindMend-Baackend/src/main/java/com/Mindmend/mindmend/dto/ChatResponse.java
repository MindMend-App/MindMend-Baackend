// src/main/java/com/Mindmend/mindmend/dto/ChatResponse.java
package main.java.com.Mindmend.mindmend.dto;
public class ChatResponse {
    private String reply;
    public ChatResponse() {}
    public ChatResponse(String reply) { this.reply = reply; }
    public String getReply() { return reply; }
    public void setReply(String r) { this.reply = r; }
}