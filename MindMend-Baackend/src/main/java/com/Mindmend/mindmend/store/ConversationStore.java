package com.Mindmend.mindmend.store;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ConversationStore {

    // Listas internas para guardar cada turno
    private final List<String> userMessages = new ArrayList<>();
    private final List<String> botMessages  = new ArrayList<>();

    /** Añade un mensaje del usuario al store */
    public void appendUserMessage(String msg) {
        if (msg != null && !msg.isBlank()) {
            userMessages.add(msg);
        }
    }

    /** Añade un mensaje del bot al store */
    public void appendBotMessage(String msg) {
        if (msg != null && !msg.isBlank()) {
            botMessages.add(msg);
        }
    }

    /** Devuelve copia inmutable de todos los mensajes de usuario */
    public List<String> getUserMessages() {
        return Collections.unmodifiableList(userMessages);
    }

    /** Devuelve copia inmutable de todos los mensajes del bot */
    public List<String> getBotMessages() {
        return Collections.unmodifiableList(botMessages);
    }

    /**
     * Devuelve la conversación completa combinando usuario y bot:
     * [user0, bot0, user1, bot1, ...]
     */
    public List<String> getFullConversation() {
        List<String> full = new ArrayList<>();
        int maxTurns = Math.max(userMessages.size(), botMessages.size());

        for (int i = 0; i < maxTurns; i++) {
            if (i < userMessages.size()) {
                full.add(userMessages.get(i));
            }
            if (i < botMessages.size()) {
                full.add(botMessages.get(i));
            }
        }
        return full;
    }

    /** Limpia toda la conversación almacenada */
    public void clear() {
        userMessages.clear();
        botMessages.clear();
    }
}
