package com.wishlist.api.entity;

import com.wishlist.api.security.oauth2.OAuth2Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
    private String imageUrl;
    private String phoneNumber;

//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Like> likes;

    @Enumerated(EnumType.STRING)
    private OAuth2Provider provider;

    private String providerId;
}
