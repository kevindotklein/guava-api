package com.guava.api.service.post;

import java.util.List;
import java.util.UUID;

import com.guava.api.common.exception.Resource;
import com.guava.api.common.exception.ResourceNotFoundException;
import com.guava.api.domain.post.dto.PostUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guava.api.domain.post.Post;
import com.guava.api.domain.post.dto.PostRequest;
import com.guava.api.domain.post.dto.PostResponse;
import com.guava.api.domain.user.User;
import com.guava.api.repositories.post.PostRepository;
import com.guava.api.repositories.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final UserRepository userRepository;

    public List<PostResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = this.postRepository.findAll(pageable);
        return posts.map(postMapper::to).toList();
    }

    public PostResponse getPost(UUID id) {
        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, Resource.POST));
        return this.postMapper.to(post);
    }

    public PostResponse createPost(PostRequest request) {
        User user = this.userRepository.findById(request.userId())
                .orElseThrow(() -> new ResourceNotFoundException(request.userId(), Resource.USER));
        Post post = new Post(UUID.randomUUID(), request.title(), request.content(),
                request.hearts(),
                request.createdAt(), user);
        this.postRepository.save(post);
        return postMapper.to(post);
    }

    public PostResponse updatePost(UUID id, PostUpdate request) {
        Post post = this.postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, Resource.POST));

        post.setTitle(request.title());
        post.setContent(request.content());
        post.setHearts(request.hearts());

        Post updatedPost = this.postRepository.save(post);
        return this.postMapper.to(updatedPost);
    }
}
