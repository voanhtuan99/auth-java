package com.example.springmongo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JWTService {

    private String generateToken (UserDetails userDetails) {
        return Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600 *60 *24))
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSignKey () {
        byte[] key = Decoders.BASE64.decode("abcdtuanvo99@1234dsadadsadsadsadd");
        return Keys.hmacShaKeyFor(key);
    }

    private <T> T extractClaim (String token, Function<Claims, T> claimsResolvers) {
        final Claims claims = extractAllClainm(token);
        return claimsResolvers.apply((claims));
    }

    private Claims extractAllClainm (String token) {
        return Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }

    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenValid (String token, UserDetails userDetail) {
        final String username = extractUserName(token);
        return (username.equals(userDetail.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired (String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }
}
