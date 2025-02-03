package com.guava.api.service.post;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guava.api.domain.post.Post;
import com.guava.api.domain.post.PostResponse;
import com.guava.api.repositories.post.PostRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Post> posts = this.postRepository.findAll(pageable);
        return posts.map(p -> postMapper.to(p)).toList();
    }
}
