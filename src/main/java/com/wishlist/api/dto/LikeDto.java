package com.wishlist.api.dto;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class LikeDto {

    @Nullable
    private long id;

    private long userId;

    private long wishId;
}
