package com.wishlist.api.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "wishes")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "wishlistId", nullable = false)
    private Wishlist wishlist;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "link", nullable = false, length = 255)
    private String link;

    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;


    @Column(name = "comment", nullable = true, length = 255)
    private String comment;
    // Constructors, getters, and setters

    public Wish() {
    }

    public Wish(Wishlist wishlist, String name, String link, BigDecimal price) {
        this.wishlist = wishlist;
        this.name = name;
        this.link = link;
        this.price = price;
    }

}