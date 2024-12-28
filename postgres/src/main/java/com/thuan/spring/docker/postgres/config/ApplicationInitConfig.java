package com.thuan.spring.docker.postgres.config;

import com.thuan.spring.docker.postgres.entity.User;
import com.thuan.spring.docker.postgres.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ApplicationInitConfig {

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository) {
        return args -> {
            if (!userRepository.existsByUsername("postgres")) {
                User user = User.builder()
                        .username("postgres")
                        .build();
                userRepository.save(user);
                log.info("postgres user has been created");
            }
        };
    }
}
