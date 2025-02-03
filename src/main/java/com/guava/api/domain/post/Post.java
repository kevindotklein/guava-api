package com.guava.api.domain.post;

import java.time.Instant;
import java.util.UUID;

import com.guava.api.domain.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "posts")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    private UUID id;

    private String title;
    private String content;
    private Integer hearts;
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
