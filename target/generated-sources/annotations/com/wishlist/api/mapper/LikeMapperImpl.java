package com.wishlist.api.mapper;

import com.wishlist.api.dto.LikeDto;
import com.wishlist.api.model.Like;
import com.wishlist.api.model.Wish;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T11:27:23+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class LikeMapperImpl extends LikeMapper {

    @Override
    public Like fromDto(LikeDto likeDto) {
        if ( likeDto == null ) {
            return null;
        }

        Like like = new Like();

        like.setId( likeDto.getId() );
        like.setUserId( likeDto.getUserId() );

        like.setWish( wishRepository.findById(likeDto.getWishId()).get() );

        return like;
    }

    @Override
    public LikeDto toDto(Like like) {
        if ( like == null ) {
            return null;
        }

        LikeDto likeDto = new LikeDto();

        Long id = likeWishId( like );
        if ( id != null ) {
            likeDto.setWishId( id );
        }
        likeDto.setId( like.getId() );
        likeDto.setUserId( like.getUserId() );

        return likeDto;
    }

    private Long likeWishId(Like like) {
        if ( like == null ) {
            return null;
        }
        Wish wish = like.getWish();
        if ( wish == null ) {
            return null;
        }
        Long id = wish.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
