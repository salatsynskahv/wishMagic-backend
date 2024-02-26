package com.wishlist.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "wishes")
public class Wish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @Column(name = "wishlist_id", nullable = false)
//    private Long wishlistId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "link", nullable = false, length = 255)
    private String link;

    @Column(name = "price")
    private String price;


    @Column(name = "comment", nullable = true, length = 255)
    private String comment;
    // Constructors, getters, and setters


    @Column(name="imageUrl", nullable = true)
    private String imageUrl;

    @JsonIgnore
    @ManyToOne
    private Wishlist wishlist;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wish")
    private List<Like> likes;
}