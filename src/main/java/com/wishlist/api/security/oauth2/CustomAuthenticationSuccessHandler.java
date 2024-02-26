package com.wishlist.api.security.oauth2;

import com.wishlist.api.entity.RefreshToken;
import com.wishlist.api.security.TokenProvider;
import com.wishlist.api.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

@RequiredArgsConstructor
@Component
public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final TokenProvider tokenProvider;

    private final RefreshTokenService refreshTokenService;


    @Value("${app.oauth2.redirectUri}")
    private String redirectUri;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        handle(request, response, authentication);
        super.clearAuthenticationAttributes(request);
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        String targetUrl = redirectUri.isEmpty() ?
                determineTargetUrl(request, response, authentication) : redirectUri;

        String token = tokenProvider.generate(authentication);
        RefreshToken refreshToken = refreshTokenService.createRefreshToken(authentication.getName());
        targetUrl = UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("accessToken", token)
                .queryParam("token", refreshToken.getToken())
                .build().toUriString();
//        targetUrl = UriComponentsBuilder.fromUriString(targetUrl).queryParam("accessToken", token).queryParam("token", ).build().toUriString();

        getRedirectStrategy().sendRedirect(request, response, targetUrl);
    }
}
