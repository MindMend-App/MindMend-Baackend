// src/main/java/com/Mindmend/mindmend/service/impl/IaServiceImpl.java
package com.Mindmend.mindmend.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.Mindmend.mindmend.dto.AnalyzeResult;
import com.Mindmend.mindmend.service.IaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class IaServiceImpl implements IaService {

    private final WebClient client;

    @Autowired
    public IaServiceImpl(WebClient iaWebClient) {
        this.client = iaWebClient;
    }

    @Override
    public String chat(String message) {
        Map<String, String> body = Map.of("message", message);
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
        Map<String, Object> body = new HashMap<>();
        body.put("messages", messages);
        return client.post()
                .uri("/analyze")
                .bodyValue(body)
                .retrieve()
                .bodyToMono(AnalyzeResult.class)
                .block();
    }
}
