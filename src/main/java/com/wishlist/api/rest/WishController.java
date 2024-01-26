package com.wishlist.api.rest;


import com.wishlist.api.model.Wish;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.service.WishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wishlist.api.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/wishItem")
public class WishController {

    private WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    Wish createWish(@RequestBody WishDto withItem) {
        return this.wishService.create(withItem);
    }


    @PatchMapping
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    Wish updateWishItem(@RequestBody WishDto wish) {
        return this.wishService.update(wish);
    }


    @GetMapping("/byWishlist")
    List<Wish> getWishesByWishlistId(@RequestParam Long wishlistId) {
        return this.wishService.getListWishesByWishlist(wishlistId);
    }

}
