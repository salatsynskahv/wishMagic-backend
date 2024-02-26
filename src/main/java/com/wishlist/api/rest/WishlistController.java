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
    @GetMapping("test")
    public List<WishlistDto> getRandom() {
        return wishlistService.findRandom();
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @GetMapping("/{wishlistId}")
    public WishlistDto getUserWishlistById(@PathVariable Long wishlistId) {
        return wishlistService.getWishlistById(wishlistId);
    }

    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    @PostMapping
    public WishlistDto create(@RequestBody WishlistDto wishlistDto,  @AuthenticationPrincipal CustomUserDetails currentUser){
        wishlistDto.setUserId(currentUser.getId());
        return wishlistService.createWishlist(wishlistDto);
    }

    @Operation(security = {@SecurityRequirement(name= BEARER_KEY_SECURITY_SCHEME)})
    @DeleteMapping("/{wishlistId}")
    public void deleteWishlist(@PathVariable Long wishlistId){
        wishlistService.deleteWishlist(wishlistId);
    }
}
