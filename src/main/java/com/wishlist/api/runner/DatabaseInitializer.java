package com.wishlist.api.runner;

import com.wishlist.api.model.User;
import com.wishlist.api.security.oauth2.OAuth2Provider;
import com.wishlist.api.security.WebSecurityConfig;
import com.wishlist.api.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
//        if (!userService.getUsers().isEmpty()) {
//            return;
//        }
//        USERS.forEach(user -> {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//            userService.saveUser(user);
//        });
//        MOVIES.forEach(movieService::saveMovie);
//        log.info("Database initialized");
    }

    private static final List<User> USERS = Arrays.asList(
            new User("admin", "admin", "Admin", "admin@mycompany.com", WebSecurityConfig.ADMIN, null, OAuth2Provider.LOCAL, "1"),
            new User("user", "user", "User", "user@mycompany.com", WebSecurityConfig.USER, null, OAuth2Provider.LOCAL, "2")
    );
}
