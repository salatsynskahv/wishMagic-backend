package com.wishlist.api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "wishes")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "wishlist_id", nullable = false)
    private Long wishlistId;

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

    public Wish(Long wishlistId, String name, String link, BigDecimal price) {
        this.wishlistId = wishlistId;
        this.name = name;
        this.link = link;
        this.price = price;
    }

}