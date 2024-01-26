package com.wishlist.api.mapper;

import com.wishlist.api.dto.WishDto;
import com.wishlist.api.dto.WishlistDto;
import com.wishlist.api.model.Wish;
import com.wishlist.api.model.Wishlist;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T11:27:23+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class WishlistMapperImpl implements WishlistMapper {

    private final WishMapper wishMapper;

    @Autowired
    public WishlistMapperImpl(WishMapper wishMapper) {

        this.wishMapper = wishMapper;
    }

    @Override
    public WishlistDto toDto(Wishlist wishlist) {
        if ( wishlist == null ) {
            return null;
        }

        WishlistDto wishlistDto = new WishlistDto();

        wishlistDto.setId( wishlist.getId() );
        wishlistDto.setUserId( wishlist.getUserId() );
        wishlistDto.setTitle( wishlist.getTitle() );
        wishlistDto.setCreatedAt( wishlist.getCreatedAt() );
        wishlistDto.setIsPrivate( wishlist.getIsPrivate() );
        wishlistDto.setStatus( wishlist.getStatus() );
        wishlistDto.setWishes( wishListToWishDtoList( wishlist.getWishes() ) );

        return wishlistDto;
    }

    @Override
    public Wishlist fromDto(WishlistDto wishlistDto) {
        if ( wishlistDto == null ) {
            return null;
        }

        Wishlist wishlist = new Wishlist();

        wishlist.setId( wishlistDto.getId() );
        wishlist.setUserId( wishlistDto.getUserId() );
        wishlist.setTitle( wishlistDto.getTitle() );
        wishlist.setCreatedAt( wishlistDto.getCreatedAt() );
        wishlist.setIsPrivate( wishlistDto.getIsPrivate() );
        wishlist.setStatus( wishlistDto.getStatus() );
        wishlist.setWishes( wishDtoListToWishList( wishlistDto.getWishes() ) );

        return wishlist;
    }

    protected List<WishDto> wishListToWishDtoList(List<Wish> list) {
        if ( list == null ) {
            return null;
        }

        List<WishDto> list1 = new ArrayList<WishDto>( list.size() );
        for ( Wish wish : list ) {
            list1.add( wishMapper.fromEntity( wish ) );
        }

        return list1;
    }

    protected List<Wish> wishDtoListToWishList(List<WishDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Wish> list1 = new ArrayList<Wish>( list.size() );
        for ( WishDto wishDto : list ) {
            list1.add( wishMapper.fromDto( wishDto ) );
        }

        return list1;
    }
}
