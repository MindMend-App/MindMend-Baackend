// src/main/java/com/Mindmend/mindmend/auth/service/impl/AuthServiceImpl.java
package com.Mindmend.mindmend.auth.service.impl;

import com.Mindmend.mindmend.auth.dto.*;
import com.Mindmend.mindmend.auth.model.User;
import com.Mindmend.mindmend.auth.repository.UserRepository;
import com.Mindmend.mindmend.auth.service.AuthService;
import com.Mindmend.mindmend.auth.config.JwtProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtProvider jwt;

    public AuthServiceImpl(UserRepository userRepo,
                           PasswordEncoder encoder,
                           JwtProvider jwt) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    @Override
    public void register(RegisterRequest req) {
        if (userRepo.findByUsername(req.username()).isPresent()) {
            throw new RuntimeException("Usuario ya existe");
        }
        User u = new User();
        u.setUsername(req.username());
        u.setPassword(encoder.encode(req.password()));
        userRepo.save(u);
    }

    @Override
    public LoginResponse login(LoginRequest req) {
        User u = userRepo.findByUsername(req.username())
                .orElseThrow(() -> new RuntimeException("Credenciales inválidas"));
        if (!encoder.matches(req.password(), u.getPassword())) {
            throw new RuntimeException("Credenciales inválidas");
        }
        String token = jwt.generateToken(u.getUsername());
        return new LoginResponse(token);
    }
}
