package com.foodforcharity.app.web.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpCookie;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.util.Optional;

@Component
public class CookieUtil {

    private final String cookieName;
    private final Duration duration;

    public CookieUtil(@Value("${security.cookie.name}") String cookieName, @Value("${security.cookie.expiration}") long validityInMilliseconds) {
        this.cookieName = cookieName;
        this.duration = Duration.ofMillis(validityInMilliseconds);
    }

    public HttpCookie create(String token) {
        return ResponseCookie.from("accesstoken", token).maxAge(duration).httpOnly(true).path("/").build();
    }

    public Optional<String> getToken(HttpServletRequest request) {
        try {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    String accessToken = cookie.getValue();
                    if (accessToken == null)
                        return Optional.empty();

                    return Optional.of(accessToken);
                }
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

}