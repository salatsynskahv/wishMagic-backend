package com.wishlist.api.dto;

import com.wishlist.api.entity.Wish;

import java.util.List;

public record UserDto(Long id, String username, String name, String email, String role, String provider, List<Wish> liked) {
}