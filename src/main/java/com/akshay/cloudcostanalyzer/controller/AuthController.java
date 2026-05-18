package com.akshay.cloudcostanalyzer.controller;

import com.akshay.cloudcostanalyzer.dto.AuthResponse;
import com.akshay.cloudcostanalyzer.dto.LoginRequest;
import com.akshay.cloudcostanalyzer.dto.RegisterRequest;
import com.akshay.cloudcostanalyzer.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}