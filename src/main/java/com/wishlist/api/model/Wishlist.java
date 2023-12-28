package com.wishlist.api.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wishlist")
    private List<Wish> wishes;
}
