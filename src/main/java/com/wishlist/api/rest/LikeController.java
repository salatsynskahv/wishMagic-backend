package com.wishlist.api.rest;


import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.mapper.LikeMapper;
import com.wishlist.api.mapper.WishMapper;
import com.wishlist.api.model.Like;
import com.wishlist.api.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/likes")
public class LikeController {

    private final LikeService likeService;

    @PostMapping
    public WishDto likeWish(@RequestBody LikeDto likeDto) {
        return likeService.createLike(likeDto);
    }

    @DeleteMapping("/{likeId}")
    public WishDto disLikeWish(@PathVariable long likeId) {
        return likeService.deleteLike(likeId);
    }
}
