package com.wishlist.api.dto;

import com.wishlist.api.model.Like;
import lombok.Data;

import java.math.BigDecimal;
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