package com.Mindmend.mindmend.service.impl;

import com.Mindmend.mindmend.dto.AnalyzeResult;
import com.Mindmend.mindmend.service.IaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IaServiceImpl implements IaService {

    private final WebClient client;

    @Autowired
    public IaServiceImpl(WebClient iaWebClient) {
        this.client = iaWebClient;
    }

    @Override
    public String chat(String message, List<String> history) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", message);
        body.put("history", history);

        return client.post()
                .uri("/chat")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(Map.class)
                .map(m -> (String)m.get("reply"))
                .block();
    }

    @Override
    public AnalyzeResult analyze(List<String> messages) {
        Map<String, Object> body = Map.of("messages", messages);
        return client.post()
                .uri("/analyze")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(AnalyzeResult.class)
                .block();
    }
}
