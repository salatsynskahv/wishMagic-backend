package com.wishlist.api.repository;

import com.wishlist.api.model.Wishlist;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    default Wishlist getById(long id) {
        return findById(id).orElseThrow();
    }

    List<Wishlist> findWishlistByUserId(Long userId);
    Optional<Wishlist> findFirstByUserId(Long userId);
}
