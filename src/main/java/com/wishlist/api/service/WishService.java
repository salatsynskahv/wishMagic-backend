package com.wishlist.api.service;

import com.wishlist.api.model.Wish;

import java.util.List;

public interface WishService {


    public Wish create(Wish wish);
    public Wish update(Wish wish);

    List<Wish> getListWishesByWishlist(Long wishlistId);
}
