package com.wishlist.api.service;

import com.wishlist.api.dto.WishDto;
import com.wishlist.api.mapper.WishMapper;
import com.wishlist.api.entity.Wish;
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
    public WishDto create(WishDto wishDto) {
        Wish wish = wishMapper.fromDto(wishDto);
        return wishMapper.fromEntity(wishRepository.save(wish));
    }

    @Override
    public Wish update(WishDto wishDto) {
        Wish wish = wishMapper.fromDto(wishDto);
        return wishRepository.save(wish);
    }

    @Override
    public void deleteWish(Long wishId) {
         wishRepository.deleteById(wishId);
    }

    @Override
    public List<Wish> getListWishesByWishlist(Long wishlistId) {
        return wishRepository.findAllByWishlistId(wishlistId);
    }
}
