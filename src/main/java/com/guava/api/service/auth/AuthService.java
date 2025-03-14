package com.guava.api.service.auth;

import com.guava.api.domain.auth.dto.LoginRequest;
import com.guava.api.domain.auth.dto.LoginResponse;
import com.guava.api.domain.auth.dto.RegisterRequest;
import com.guava.api.domain.user.User;
import com.guava.api.domain.user.UserRole;
import com.guava.api.domain.user.dto.UserResponse;
import com.guava.api.repositories.user.UserRepository;
import com.guava.api.service.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtEncoder jwtEncoder;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public LoginResponse login(LoginRequest request) {
        User user = this.userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialsException("User or password are invalid"));

        if(!bCryptPasswordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialsException("User or password are invalid");
        }

        Instant now = Instant.now();
        long expiresIn = 300L;

        var claims = JwtClaimsSet.builder()
                .issuer("guava")
                .subject(user.getId().toString())
                .expiresAt(now.plusSeconds(expiresIn))
                .issuedAt(now)
                .build();

        String token = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new LoginResponse(token, expiresIn);
    }

    public UserResponse register(RegisterRequest request) {
        this.userRepository.findByEmail(request.email())
                .ifPresent(u -> {
                    throw new BadCredentialsException("An account with this email already exists");
                });

        User user = new User(
                UUID.randomUUID(),
                request.email(),
                request.username(),
                passwordEncoder.encode(request.password()),
                UserRole.USER,
                Instant.now());

        User saved = this.userRepository.save(user);
        return this.userMapper.to(saved);
    }
}
