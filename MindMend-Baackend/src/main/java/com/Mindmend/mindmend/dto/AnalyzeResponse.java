// src/main/java/com/Mindmend/mindmend/dto/AnalyzeResponse.java
package com.Mindmend.mindmend.dto;
public class AnalyzeResponse {
    private String label;
    private double score;
    public AnalyzeResponse() {}
    public AnalyzeResponse(String label, double score) {
        this.label = label; this.score = score;
    }
    public String getLabel() { return label; }
    public void setLabel(String l) { this.label = l; }
    public double getScore() { return score; }
    public void setScore(double s) { this.score = s; }
}