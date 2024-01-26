package com.wishlist.api.rest;

import com.wishlist.api.dto.WishlistDto;
import com.wishlist.api.security.CustomUserDetails;
import com.wishlist.api.service.WishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wishlist.api.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping
    public List<WishlistDto> getUserWishlists(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return wishlistService.findUserWishlists(currentUser.getId());
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/{id}")
    public WishlistDto getUserWishlistById(@AuthenticationPrincipal CustomUserDetails currentUser, @PathVariable Long id) {
        return wishlistService.getWishlistById(id);
    }
}
