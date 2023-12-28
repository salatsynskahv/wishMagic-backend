package com.wishlist.api.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class WishDto {

    private Long id;

    private Long wishlistId;

    private String name;

    private String link;

    private BigDecimal price;

    private String comment;

    private String imageUrl;
}