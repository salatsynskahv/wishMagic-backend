package com.wishlist.api.mapper;


import com.wishlist.api.dto.WishlistDto;
import com.wishlist.api.entity.Wishlist;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = WishMapper.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface WishlistMapper {

    WishlistDto toDto(Wishlist wishlist);

    Wishlist fromDto(WishlistDto wishlistDto);
}
