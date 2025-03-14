package com.guava.api.domain.user;

import java.time.Instant;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;
    private String username;
    private String password;

    //TODO: test postgres ENUM
    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Instant createdAt;
}
