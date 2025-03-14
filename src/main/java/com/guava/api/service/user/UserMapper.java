package com.guava.api.service.user;

import com.guava.api.domain.user.User;
import com.guava.api.domain.user.dto.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponse to(User user);
}
