package com.Mindmend.mindmend.auth.service;

import com.Mindmend.mindmend.auth.dto.LoginRequest;
import com.Mindmend.mindmend.auth.dto.LoginResponse;
import com.Mindmend.mindmend.auth.dto.RegisterRequest;

public interface AuthService {
    void register(RegisterRequest req);
    LoginResponse login(LoginRequest req);
}