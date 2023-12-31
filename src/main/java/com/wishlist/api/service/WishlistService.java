package com.wishlist.api.service;
import com.wishlist.api.model.Wishlist;
import java.util.List;

public interface  WishlistService {

    List<Wishlist> findUsersWishlist(Long userId);
    Wishlist createDefaultWishlist(Long userId);

    Wishlist createWishlist(Wishlist wishlist);

    Boolean userHasWishlist(Long userId);

}
