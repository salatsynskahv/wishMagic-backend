package com.wishlist.api.dto;

import com.wishlist.api.model.Wish;
import lombok.Data;

import java.util.List;

@Data
public class WishlistDto {

    private Long id;

    private Long userId;

    private String title;

    private String createdAt;

    private Boolean isPrivate;

    private String status;

    private List<WishDto> wishes;
}
