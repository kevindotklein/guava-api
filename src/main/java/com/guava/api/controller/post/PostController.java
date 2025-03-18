package com.guava.api.controller.post;

import java.util.List;
import java.util.UUID;

import com.guava.api.domain.post.dto.PostUpdate;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.guava.api.domain.post.dto.PostRequest;
import com.guava.api.domain.post.dto.PostResponse;
import com.guava.api.service.post.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<PostResponse>> getPosts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(this.postService.getPosts(page, size));
    }

    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody @Valid PostRequest request,
                                                   JwtAuthenticationToken token) {
        return new ResponseEntity<>(this.postService.createPost(request, token),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable @NotNull UUID id) {
        return ResponseEntity.ok(this.postService.getPost(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable @NotNull UUID id, @RequestBody @Valid PostUpdate request) {
        return ResponseEntity.ok(this.postService.updatePost(id, request));
    }

    //TODO: soft delete
}
