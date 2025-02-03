package com.guava.api.repositories.post;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guava.api.domain.post.Post;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
