// src/main/java/com/Mindmend/mindmend/service/IaService.java
package com.Mindmend.mindmend.service;

import com.Mindmend.mindmend.dto.ChatRequest;
import com.Mindmend.mindmend.dto.AnalyzeResult;
import java.util.List;

public interface IaService {
    String chat(String message, List<String> history);

    AnalyzeResult analyze(List<String> messages);
}