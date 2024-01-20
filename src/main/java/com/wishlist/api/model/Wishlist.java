package com.wishlist.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String title;
    private String createdAt;
    private Boolean isPrivate;
    private String status;
    @ToString.Exclude
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wishlist")
    private List<Wish> wishes;
}
