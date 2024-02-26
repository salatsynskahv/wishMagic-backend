package com.wishlist.api.rest;


import com.wishlist.api.entity.Wish;
import com.wishlist.api.dto.WishDto;
import com.wishlist.api.service.WishService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.wishlist.api.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RestController
@RequestMapping("/api/wish")
public class WishController {

    private WishService wishService;

    public WishController(WishService wishService) {
        this.wishService = wishService;
    }

    @PostMapping
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    public WishDto createWish(@RequestBody WishDto withItem) {
        return this.wishService.create(withItem);
    }


    @PatchMapping
    @Operation(security = {@SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME)})
    public Wish updateWishItem(@RequestBody WishDto wish) {
        return this.wishService.update(wish);
    }


    @GetMapping("/byWishlist")
    public List<Wish> getWishesByWishlistId(@RequestParam Long wishlistId) {
        return wishService.getListWishesByWishlist(wishlistId);
    }

    @DeleteMapping("/{wishId}")
    public void deleteWish(@PathVariable("wishId") Long wishId){
        wishService.deleteWish(wishId);
    }

}
