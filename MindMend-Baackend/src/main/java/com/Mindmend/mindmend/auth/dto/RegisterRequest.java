package com.Mindmend.mindmend.auth.dto;

public record RegisterRequest(
        String username,
        String password
) {}