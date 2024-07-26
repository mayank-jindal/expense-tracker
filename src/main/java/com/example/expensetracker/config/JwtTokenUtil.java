//package com.example.expensetracker.config;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Configuration
//public class JwtTokenUtil {
//
//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    @Value("${jwt.expiration}")
//    private long expiration;
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public Claims getClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//    public String getUsername(String token) {
//        return getClaims(token).getSubject();
//    }
//
//    public boolean isTokenExpired(String token) {
//        return getClaims(token).getExpiration().before(new Date());
//    }
//
//    public boolean validateToken(String token, String username) {
//        return (username.equals(getUsername(token)) && !isTokenExpired(token));
//    }
//}
