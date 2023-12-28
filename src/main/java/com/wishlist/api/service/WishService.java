package com.wishlist.api.service;

import com.wishlist.api.model.Wish;
import com.wishlist.api.dto.WishDto;

import java.util.List;

public interface WishService {

    public Wish create(WishDto wishDto);
    public Wish update(Wish wish);
    List<Wish> getListWishesByWishlist(Long wishlistId);
}
