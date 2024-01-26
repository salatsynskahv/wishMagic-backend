package com.wishlist.api.model;

import jakarta.persistence.*;

@Entity
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name="wishId", referencedColumnName = "id")
    private Wish wish;
}
