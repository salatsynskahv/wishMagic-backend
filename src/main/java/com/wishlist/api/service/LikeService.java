package com.wishlist.api.service;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.dto.WishDto;

public interface LikeService {

    WishDto createLike(LikeDto likeDto);

    WishDto deleteLike(long id);
}
