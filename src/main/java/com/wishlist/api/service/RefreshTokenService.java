package com.wishlist.api.service;

import com.wishlist.api.entity.RefreshToken;
import com.wishlist.api.entity.User;
import com.wishlist.api.exception.UserNotFoundException;
import com.wishlist.api.repository.RefreshTokenRepository;
import com.wishlist.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    private RefreshTokenRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Value("${app.jwt.refreshExpiration.minutes}")
    private Integer refreshExpiration;


    public RefreshToken createRefreshToken(String username) {
        User user =  userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException("User with name: " + username+" was not found"));

      repository.findByUser(user)
              .ifPresent(
                (refreshToken) -> repository.delete(refreshToken)
              );

        RefreshToken refreshToken = RefreshToken.builder()
                .user(user)
                .token(UUID.randomUUID().toString())
                .expireDate(ZonedDateTime.now().plusMinutes(refreshExpiration).toInstant())
                .build();

        return repository.save(refreshToken);
    }



    public Optional<RefreshToken> findByToken(String token) {
       return repository.findByToken(token);
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if(token.getExpireDate().compareTo(Instant.now())< 0) {
            repository.delete(token);
            throw new RuntimeException(token.getToken() + "Refresh token was expired");
        }
        return token;
    }

}
