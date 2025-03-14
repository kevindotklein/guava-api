package com.guava.api.controller.auth;

import com.guava.api.domain.auth.dto.LoginRequest;
import com.guava.api.domain.auth.dto.LoginResponse;
import com.guava.api.domain.auth.dto.RegisterRequest;
import com.guava.api.domain.user.dto.UserResponse;
import com.guava.api.service.auth.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid RegisterRequest request) {
        return new ResponseEntity<>(this.authService.register(request),HttpStatus.CREATED);
    }
}
