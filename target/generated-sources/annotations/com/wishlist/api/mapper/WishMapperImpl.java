package com.wishlist.api.mapper;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.model.Like;
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
public class WishMapperImpl extends WishMapper {

    private final LikeMapper likeMapper;

    @Autowired
    public WishMapperImpl(LikeMapper likeMapper) {

        this.likeMapper = likeMapper;
    }

    @Override
    public Wish fromDto(WishDto wishDto) {
        if ( wishDto == null ) {
            return null;
        }

        Wish wish = new Wish();

        wish.setId( wishDto.getId() );
        wish.setName( wishDto.getName() );
        wish.setLink( wishDto.getLink() );
        wish.setPrice( wishDto.getPrice() );
        wish.setComment( wishDto.getComment() );
        wish.setImageUrl( wishDto.getImageUrl() );
        wish.setLikes( likeDtoListToLikeList( wishDto.getLikes() ) );

        wish.setWishlist( wishlistRepository.findById(wishDto.getWishlistId()).get() );

        return wish;
    }

    @Override
    public WishDto fromEntity(Wish entity) {
        if ( entity == null ) {
            return null;
        }

        WishDto wishDto = new WishDto();

        Long id = entityWishlistId( entity );
        if ( id != null ) {
            wishDto.setWishlistId( id );
        }
        if ( entity.getId() != null ) {
            wishDto.setId( entity.getId() );
        }
        wishDto.setName( entity.getName() );
        wishDto.setLink( entity.getLink() );
        wishDto.setPrice( entity.getPrice() );
        wishDto.setComment( entity.getComment() );
        wishDto.setImageUrl( entity.getImageUrl() );
        wishDto.setLikes( likeListToLikeDtoList( entity.getLikes() ) );

        return wishDto;
    }

    protected List<Like> likeDtoListToLikeList(List<LikeDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Like> list1 = new ArrayList<Like>( list.size() );
        for ( LikeDto likeDto : list ) {
            list1.add( likeMapper.fromDto( likeDto ) );
        }

        return list1;
    }

    private Long entityWishlistId(Wish wish) {
        if ( wish == null ) {
            return null;
        }
        Wishlist wishlist = wish.getWishlist();
        if ( wishlist == null ) {
            return null;
        }
        Long id = wishlist.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<LikeDto> likeListToLikeDtoList(List<Like> list) {
        if ( list == null ) {
            return null;
        }

        List<LikeDto> list1 = new ArrayList<LikeDto>( list.size() );
        for ( Like like : list ) {
            list1.add( likeMapper.toDto( like ) );
        }

        return list1;
    }
}
