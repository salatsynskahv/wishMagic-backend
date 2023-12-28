package com.wishlist.api.service;

import com.wishlist.api.dto.WishDto;
import com.wishlist.api.mapper.WishMapper;
import com.wishlist.api.model.Wish;
import com.wishlist.api.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WishServiceImpl implements WishService {

    private final WishRepository wishRepository;

    private final WishMapper wishMapper;

    @Override
    public Wish create(WishDto wishDto) {
        Wish wish = wishMapper.fromDto(wishDto);
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
