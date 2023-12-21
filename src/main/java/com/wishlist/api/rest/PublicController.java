package com.wishlist.api.rest;

import com.wishlist.api.model.WishScrapped;
import com.wishlist.api.service.UserService;
import com.wishlist.api.service.WishScrapperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {

    private final UserService userService;

    private final WishScrapperService wishScrapper;


    public PublicController(UserService userService, WishScrapperService wishScrapper) {
        this.userService = userService;
        this.wishScrapper = wishScrapper;
    }

    @GetMapping("/scrappingFromUrl")
    public WishScrapped scrappingFromUrl(@RequestParam String url) {
        return wishScrapper.getInfoFromUrl(url);
    }
}
