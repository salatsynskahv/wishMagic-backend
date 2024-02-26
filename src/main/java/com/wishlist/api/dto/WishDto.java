package com.wishlist.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class WishDto {

    private long id;

    private long wishlistId;

    private String name;

    private String link;

    private String price;

    private String comment;

    private String imageUrl;

    private List<LikeDto> likes;
}