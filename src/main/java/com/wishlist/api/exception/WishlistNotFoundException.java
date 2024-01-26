package com.wishlist.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class WishlistNotFoundException extends RuntimeException{

    public WishlistNotFoundException(String message) {
        super(message);
    }
}
