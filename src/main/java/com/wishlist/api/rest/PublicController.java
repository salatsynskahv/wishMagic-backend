package com.wishlist.api.rest;

import com.wishlist.api.model.WishScrapped;
import com.wishlist.api.service.UserService;
import com.wishlist.api.service.WishScrapperService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final UserService userService;

    private final WishScrapperService wishScrapper;


    public PublicController(UserService userService, WishScrapperService wishScrapper) {
        this.userService = userService;
        this.wishScrapper = wishScrapper;
    }

    @GetMapping
    public String checkStatus() {
        return "Hello!";
    }
    @GetMapping("/scrappingFromUrl")
    public WishScrapped scrappingFromUrl(@RequestParam String url) {
        return wishScrapper.getInfoFromUrl(url);
    }
}
