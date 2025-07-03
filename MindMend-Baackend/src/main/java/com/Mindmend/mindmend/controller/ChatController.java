// src/main/java/com/Mindmend/mindmend/controller/ChatController.java
package main.java.com.Mindmend.mindmend.controller;

import java.util.List;
import com.yourcompany.mindmend.dto.ChatRequest;
import com.yourcompany.mindmend.dto.ChatResponse;
import com.yourcompany.mindmend.dto.AnalyzeResponse;
import com.yourcompany.mindmend.service.IaService;
import com.yourcompany.mindmend.store.ConversationStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        String userMsg = req.getMessage();
        String botReply = iaService.chat(userMsg);

        store.appendUserMessage(userMsg);
        store.appendBotMessage(botReply);

        return new ChatResponse(botReply);
    }

    @GetMapping("/analyze")
    public AnalyzeResponse analyze() {
        List<String> userMsgs = store.getUserMessages();
        AnalyzeResult result = iaService.analyze(userMsgs);
        return new AnalyzeResponse(result.getLabel(), result.getScore());
    }
}
