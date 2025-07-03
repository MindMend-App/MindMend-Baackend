// src/main/java/com/Mindmend/mindmend/service/IaService.java
package main.java.com.Mindmend.mindmend.service;

import com.yourcompany.mindmend.dto.AnalyzeResult;

public interface IaService {
    String chat(String message);
    AnalyzeResult analyze(java.util.List<String> messages);
}