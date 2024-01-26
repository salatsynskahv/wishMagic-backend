package com.wishlist.api.service;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.model.Like;

public interface LikeService {

    WishDto createLike(LikeDto likeDto);

    WishDto deleteLike(long id);
}
