package com.wishlist.api.service;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.mapper.LikeMapper;
import com.wishlist.api.mapper.WishMapper;
import com.wishlist.api.model.Like;
import com.wishlist.api.model.Wish;
import com.wishlist.api.repository.LikeRepository;
import com.wishlist.api.repository.WishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {

    private final LikeRepository likesRepository;

    private final WishRepository wishRepository;

    private final LikeMapper likeMapper;

    private final WishMapper wishMapper;

    @Override
    public WishDto createLike(LikeDto likeDto) {
        Like like = likeMapper.fromDto(likeDto);
        likesRepository.save(like);
        Wish wish = wishRepository.findById(likeDto.getWishId()).get();
        return wishMapper.fromEntity(wish);
    }

    @Override
    public WishDto deleteLike(long id) {
        Like like = likesRepository.findById(id).get();
        likesRepository.deleteById(id);
        Wish wish = wishRepository.findById(like.getWish().getId()).get();
        return wishMapper.fromEntity(wish);
    }
}

