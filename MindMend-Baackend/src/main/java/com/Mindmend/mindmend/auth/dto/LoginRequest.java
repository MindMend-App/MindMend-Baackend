package com.Mindmend.mindmend.auth.dto;

public record LoginRequest(
        String username,
        String password
) {}