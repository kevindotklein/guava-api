package com.guava.api.service.post;

import org.mapstruct.Mapper;

import com.guava.api.domain.post.Post;
import com.guava.api.domain.post.dto.PostResponse;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse to(Post post);
}
