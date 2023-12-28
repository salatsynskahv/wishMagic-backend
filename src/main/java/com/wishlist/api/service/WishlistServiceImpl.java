package com.wishlist.api.service;

import com.wishlist.api.model.Wishlist;
import com.wishlist.api.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    String defaultWishlistName = "My wishlist";

    final private WishlistRepository wishlistRepository;


    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public List<Wishlist> findUsersWishlist(Long userId) {
        List<Wishlist> wishlistByUserId = wishlistRepository.findWishlistByUserId(userId);
        return wishlistByUserId;
    }

    public Wishlist createDefaultWishlist(Long userId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setTitle(defaultWishlistName);
        wishlist.setCreatedAt(new Date().toString());
        wishlist.setIsPrivate(false);
        return this.wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist createWishlist(Wishlist wishlist) {
        return this.wishlistRepository.save(wishlist);
    }

    @Override
    public Boolean userHasWishlist(Long userId) {
        return this.wishlistRepository.findFirstByUserId(userId).isPresent();
    }

}
