package com.thuan.spring.docker.mysql.config;

import com.thuan.spring.docker.mysql.entity.User;
import lombok.extern.slf4j.Slf4j;
import com.thuan.spring.docker.mysql.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationInitConfig {

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsByUsername("mysql")) {
                User user = User.builder()
                        .username("mysql")
                        .build();
                userRepository.save(user);
                log.info("mysql user has been created");
            }
        };
    }
}
