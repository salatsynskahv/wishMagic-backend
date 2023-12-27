package com.wishlist.api.service;

import com.wishlist.api.model.Wish;
import com.wishlist.api.repository.WishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;

    public WishServiceImpl(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    @Override
    public Wish create(Wish wish) {
        return wishRepository.save(wish);
    }

    @Override
    public Wish update(Wish wish) {
        return wishRepository.save(wish);
    }

    @Override
    public List<Wish> getListWishesByWishlist(Long wishlistId) {
        return wishRepository.findAllByWishlistId(wishlistId);
    }
}
