package com.wishlist.api.repository;

import com.wishlist.api.entity.Wish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {

     List<Wish> findAllByWishlistId(Long wishlistId);
}
