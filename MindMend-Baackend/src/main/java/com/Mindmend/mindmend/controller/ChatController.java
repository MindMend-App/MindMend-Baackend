package com.Mindmend.mindmend.controller;

import com.Mindmend.mindmend.dto.ChatRequest;
import com.Mindmend.mindmend.dto.ChatResponse;
import com.Mindmend.mindmend.dto.AnalyzeResponse;

import com.Mindmend.mindmend.service.IaService;

import com.Mindmend.mindmend.store.ConversationStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final IaService iaService;
    private final ConversationStore store;

    @Autowired
    public ChatController(IaService iaService, ConversationStore store) {
        this.iaService = iaService;
        this.store    = store;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest req) {
        // 1) guardamos el turno de usuario
        store.appendUserMessage(req.getMessage());

        // 2) llamamos al microservicio Python con history des de el front
        String botReply = iaService.chat(req.getMessage(), req.getHistory());

        // 3) guardamos turno de bot
        store.appendBotMessage(botReply);

        return new ChatResponse(botReply);
    }

    @GetMapping("/analyze")
    public AnalyzeResponse analyze() {
        List<String> userMsgs = store.getUserMessages();
        var result = iaService.analyze(userMsgs);
        return new AnalyzeResponse(result.getLabel(), result.getScore());
    }
}
