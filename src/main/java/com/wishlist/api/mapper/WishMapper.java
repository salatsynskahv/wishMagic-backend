package com.wishlist.api.mapper;

import com.wishlist.api.dto.WishDto;
import com.wishlist.api.model.Wish;
import com.wishlist.api.repository.WishlistRepository;
import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class WishMapper {

    @Autowired
    protected WishlistRepository wishlistRepository;

    @Mapping(target = "wishlist", expression = "java(wishlistRepository.findById(wishDto.getWishlistId()).get())")
    public abstract Wish fromDto(WishDto wishDto);

//    @Mapping(target = "wishlist")
//    public abstract WishDto fromEntity(Wish entity);
}
