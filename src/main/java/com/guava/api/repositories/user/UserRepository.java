package com.guava.api.repositories.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.guava.api.domain.user.User;

@Service
public interface UserRepository extends JpaRepository<User, UUID> {
}
