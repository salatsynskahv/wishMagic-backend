package com.wishlist.api.mapper;

import com.wishlist.api.model.User;
import com.wishlist.api.rest.dto.UserDto;

public interface UserMapper {

    UserDto toUserDto(User user);
}