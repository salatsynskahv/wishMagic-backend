package com.wishlist.api.service;

import com.wishlist.api.dto.WishlistDto;
import com.wishlist.api.mapper.WishlistMapper;
import com.wishlist.api.entity.Wishlist;
import com.wishlist.api.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WishlistServiceImpl implements WishlistService {

    private static final String DEFAULT_WISHLIST_NAME = "My wishlist";
    private final WishlistRepository wishlistRepository;
    private final WishlistMapper wishlistMapper;


    public WishlistServiceImpl(WishlistRepository wishlistRepository, WishlistMapper wishlistMapper) {
        this.wishlistRepository = wishlistRepository;
        this.wishlistMapper = wishlistMapper;
    }

    @Override
    public List<WishlistDto> findRandom() {
        List<Wishlist> wishlists = wishlistRepository.findFirst10By();
        return wishlists.stream().map(wishlistMapper::toDto).toList();
    }

    @Override
    public List<WishlistDto> findUserWishlists(Long userId) {
        List<Wishlist> wishlists = wishlistRepository.findWishlistByUserId(userId);
        return wishlists.stream().map(wishlistMapper::toDto).toList();
    }

    public WishlistDto createDefaultWishlist(Long userId) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUserId(userId);
        wishlist.setTitle(DEFAULT_WISHLIST_NAME);
        wishlist.setCreatedAt(new Date().toString());
        wishlist.setIsPrivate(false);
        return wishlistMapper.toDto(wishlistRepository.save(wishlist));
    }

    @Override
    public WishlistDto createWishlist(WishlistDto wishlistDto) {
        Wishlist wishlist = wishlistMapper.fromDto(wishlistDto);
        return wishlistMapper.toDto(this.wishlistRepository.save(wishlist));
    }

    @Override
    public Boolean userHasWishlist(Long userId) {
        return this.wishlistRepository.findFirstByUserId(userId).isPresent();
    }

    @Override
    public WishlistDto getWishlistById(Long wishlistId) {
        return wishlistMapper.toDto(wishlistRepository.findById(wishlistId).get());
    }

    @Override
    public void deleteWishlist(Long wishlistId) {
         wishlistRepository.deleteById(wishlistId);
    }


}
