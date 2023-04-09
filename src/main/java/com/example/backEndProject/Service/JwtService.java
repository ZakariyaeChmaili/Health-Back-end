/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.backEndProject.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

/**
 *
 * @author ADMIN
 */
@Component
public class JwtService {

    private final String secretKey = "77397A244326462948404D635166546xdsfvdgvA576E5A7234753778214125442A472D4B";

    public String generateToken(String cni) {
        return Jwts
                .builder()
                .claim("cni", cni)
                .claim("role", "partient")
                .claim("toto", "chaymae")
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(this.secretKey)), SignatureAlgorithm.HS256)
                //                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60*2))

                .compact();
    }

    public String extractClaimFromToken(String token, String claim) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey)))
                .build()
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
        return claims.get(claim, String.class);
    }

}
