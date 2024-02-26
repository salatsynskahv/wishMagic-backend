package com.wishlist.api.repository;

import com.wishlist.api.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    default Wishlist getById(long id) {
        return findById(id).orElseThrow();
    }

    List<Wishlist> findWishlistByUserId(Long userId);
    Optional<Wishlist> findFirstByUserId(Long userId);

    List<Wishlist> findFirst10By();
}
