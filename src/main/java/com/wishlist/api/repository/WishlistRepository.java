package com.wishlist.api.repository;

import com.wishlist.api.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    public List<Wishlist> findWishlistByUserId(Long userId);

    public Optional<Wishlist> findFirstByUserId(Long userId);
}
