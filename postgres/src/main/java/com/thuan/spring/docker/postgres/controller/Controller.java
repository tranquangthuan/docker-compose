package com.thuan.spring.docker.postgres.controller;

import com.thuan.spring.docker.postgres.entity.User;
import com.thuan.spring.docker.postgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class Controller {

  @Autowired
  private UserRepository userRepository;

  @GetMapping
  public List<User> getAll() {
    return userRepository.findAll().stream()
        .map(u -> User.builder().username("From Mysql " + u.getUsername())
            .id(u.getId()).build()).collect(Collectors.toList());
  }
}
