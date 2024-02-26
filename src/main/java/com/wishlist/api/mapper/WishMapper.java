package com.wishlist.api.mapper;

import com.wishlist.api.dto.WishDto;
import com.wishlist.api.entity.Wish;
import com.wishlist.api.repository.WishlistRepository;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = LikeMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class WishMapper {

    @Autowired
    protected WishlistRepository wishlistRepository;

    @Mapping(target = "wishlist", expression = "java(wishlistRepository.findById(wishDto.getWishlistId()).get())")
    public abstract Wish fromDto(WishDto wishDto);

    @Mapping(target = "wishlistId", source="wishlist.id")
    public abstract WishDto fromEntity(Wish entity);
}
