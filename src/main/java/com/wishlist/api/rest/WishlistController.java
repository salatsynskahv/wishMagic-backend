package com.wishlist.api.rest;

import com.wishlist.api.exception.UserNotFoundException;
import com.wishlist.api.model.Wishlist;
import com.wishlist.api.security.CustomUserDetails;
import com.wishlist.api.service.WishlistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wishlist.api.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;


@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService){
        this.wishlistService = wishlistService;
    }


    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping
    public List<Wishlist> getUserWishlists(@AuthenticationPrincipal CustomUserDetails currentUser) {
        return wishlistService.findUsersWishlist(currentUser.getId());
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/{id}")
    public Wishlist getUserWishlistById(@AuthenticationPrincipal CustomUserDetails currentUser, @PathVariable Long id) {
        System.out.println(id);
        Wishlist result = wishlistService.findWishlistById(id).orElseThrow(() -> new UserNotFoundException("Wishlist not found"));
        System.out.println(result);
        return result;
    }
}
