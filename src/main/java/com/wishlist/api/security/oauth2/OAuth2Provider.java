package com.wishlist.api.security.oauth2;

import com.fasterxml.jackson.annotation.JsonValue;

public enum OAuth2Provider {
    LOCAL, GITHUB, GOOGLE;

    @JsonValue
    public String value(){
        return this.name();
    }
}
