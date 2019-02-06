package com.stackroute.webtokens.security;

import com.stackroute.webtokens.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {
    public String generate(User user) {

        Claims claims = Jwts.claims()
                .setSubject(user.getUserName());
        claims.put("password", user.getPassword());



        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();


    }
}
