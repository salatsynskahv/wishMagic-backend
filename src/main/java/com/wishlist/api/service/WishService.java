package com.wishlist.api.service;

import com.wishlist.api.entity.Wish;
import com.wishlist.api.dto.WishDto;

import java.util.List;

public interface WishService {

    WishDto create(WishDto wishDto);
    Wish update(WishDto wish);

    void deleteWish(Long wishId);
    List<Wish> getListWishesByWishlist(Long wishlistId);


}
