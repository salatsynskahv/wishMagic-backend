package com.wishlist.api.service;
import com.wishlist.api.dto.WishlistDto;

import java.util.List;

public interface  WishlistService {


    List<WishlistDto> findRandom();
    List<WishlistDto> findUserWishlists(Long userId);
    WishlistDto createDefaultWishlist(Long userId);

    WishlistDto createWishlist(WishlistDto wishlist);

    Boolean userHasWishlist(Long userId);

    WishlistDto getWishlistById(Long wishlistId);

    void deleteWishlist(Long wishlistId);
}
