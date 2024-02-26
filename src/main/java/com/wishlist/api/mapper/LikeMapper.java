package com.wishlist.api.mapper;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.entity.Like;
import com.wishlist.api.repository.WishRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class LikeMapper {

    @Autowired
    protected WishRepository wishRepository;

    @Mapping(target = "wish", expression = "java(wishRepository.findById(likeDto.getWishId()).get())")
    public abstract Like fromDto(LikeDto likeDto);

    @Mapping(target = "wishId", source = "wish.id")
    public abstract LikeDto toDto(Like like);
}