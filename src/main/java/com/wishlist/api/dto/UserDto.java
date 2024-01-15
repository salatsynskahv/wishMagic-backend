package com.wishlist.api.dto;

public record UserDto(Long id, String username, String name, String email, String role, String provider) {
}