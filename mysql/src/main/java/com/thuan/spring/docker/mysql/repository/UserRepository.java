package com.thuan.spring.docker.mysql.repository;

import com.thuan.spring.docker.mysql.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUsername(String user);
}
