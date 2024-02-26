package com.wishlist.api.service;

import com.wishlist.api.entity.WishScrapped;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class WishScrapperService {

    public WishScrapped getInfoFromUrl(String url) {
        WishScrapped result = new WishScrapped();
        try {
            Document doc = Jsoup.connect(url).get();
            result.setName(doc.title());
            Elements elementsWithPrice = doc.select("[class*='price']:containsOwn(₴), [class*='price']:containsOwn($), [class*='price']:containsOwn('грн'), span.price-new, span.price");
            String price = elementsWithPrice.text();
            try {
                Element imageUrl1 = doc.select(".product-image img").first();

                Element imageUrl2 = doc.select("img[alt~='product picture']").first();

                Element imageUrl3 = doc.select(".product-image img[alt~='main image']").first();

                if (imageUrl1 != null) {
                    result.setImageUrl(imageUrl1.attr("src"));
                } else if (imageUrl2 != null ) {
                    result.setImageUrl(imageUrl2.attr("src"));
                } else if (imageUrl3 != null) {
                    result.setImageUrl(imageUrl3.attr("src"));
                }else {
                    Elements images = doc.select("img"); // Select all img elements

                    for (Element image : images) {
                        String imageUrl = image.attr("src"); // Get the image URL
                        String heightAttr = image.attr("height"); // Get the height attribute

                        if (heightAttr != null) {
                            try {
                                int height = Integer.parseInt(heightAttr); // Convert height string to integer
                                if (height > 300) { // Check if height is greater than 300
                                    result.setImageUrl(imageUrl);
                                    break; // No need to check other images
                                }
                            } catch (NumberFormatException e) {
                                // Ignore images with invalid height attribute
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
            result.setPrice(price);
            System.out.println("title" + doc.title());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return result;
    }
}
