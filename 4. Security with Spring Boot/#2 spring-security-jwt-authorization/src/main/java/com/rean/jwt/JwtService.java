package com.rean.jwt;

import com.rean.security.CustomUserDetail;
import io.jsonwebtoken.Claims;

import java.security.Key;

public interface JwtService {

    Claims extractClaims(String token);
    Key getKey();
    String generateToken(CustomUserDetail customUserDetail);
    String refreshToken(CustomUserDetail customUserDetail);
    boolean isValidToken(String token);
}
