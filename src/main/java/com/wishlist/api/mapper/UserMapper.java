package com.wishlist.api.mapper;

import com.wishlist.api.model.User;
import com.wishlist.api.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toUserDto(User user);
}