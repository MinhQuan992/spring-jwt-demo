package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Minh Quan", "minhquan", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Vo Tran", "votran", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Minh Hien", "minhhien", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Le Anh", "leanh", "1234", new ArrayList<>()));

            userService.addRoleToUser("minhquan", "ROLE_USER");
            userService.addRoleToUser("votran", "ROLE_MANAGER");
            userService.addRoleToUser("minhhien", "ROLE_ADMIN");
            userService.addRoleToUser("leanh", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("leanh", "ROLE_ADMIN");
            userService.addRoleToUser("leanh", "ROLE_USER");
        };
    }
}
