package com.wishlist.api.repository;

import com.wishlist.api.model.Wish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WishRepository extends JpaRepository<Wish, Long> {

    public List<Wish> findAllByWishlistId(Long wishlistId);
}
