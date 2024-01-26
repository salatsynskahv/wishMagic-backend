package com.wishlist.api.mapper;

import com.wishlist.api.dto.UserDto;
import com.wishlist.api.model.User;
import com.wishlist.api.model.Wish;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T11:27:23+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String username = null;
        String name = null;
        String email = null;
        String role = null;
        String provider = null;

        id = user.getId();
        username = user.getUsername();
        name = user.getName();
        email = user.getEmail();
        role = user.getRole();
        if ( user.getProvider() != null ) {
            provider = user.getProvider().name();
        }

        List<Wish> liked = null;

        UserDto userDto = new UserDto( id, username, name, email, role, provider, liked );

        return userDto;
    }
}
