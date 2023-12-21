package com.wishlist.api.repository;

import com.wishlist.api.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
}
