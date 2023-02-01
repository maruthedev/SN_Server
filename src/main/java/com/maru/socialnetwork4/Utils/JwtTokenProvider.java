package com.maru.socialnetwork4.Utils;

import com.maru.socialnetwork4.Model.User;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.time.Instant;
import java.util.Date;

@Component
public class JwtTokenProvider {
    private final static String JwtSecretKey = "JwtSecretKey";
    private final static int expiredTimeInMs = 86400000;

    public String generateToken(User user){
        Date rn = Date.from(Instant.now());
        Date expiredDate = new Date(rn.getTime() + expiredTimeInMs);

        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(rn)
                .setExpiration(expiredDate)
                .signWith(SignatureAlgorithm.HS512, JwtSecretKey)
                .compact();
    }

    public int getIdFromToken(String token){
        return Integer.parseInt(Jwts
                .parser()
                .setSigningKey(JwtSecretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject());
    }
}
