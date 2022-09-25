package com.example.jpatwodb.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JWTUtil {

    private String secretKey;
    private int lifeTime;
    private String issuer;

    public String sign(String username) {
        Claims claims = Jwts.claims();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, lifeTime);
        claims.setExpiration(calendar.getTime());
        claims.put("username", username);
        if (issuer != null) {
            claims.setIssuer(issuer);
        }

        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.builder().setClaims(claims).signWith(key, SignatureAlgorithm.HS256).compact();
    }

    public Map<String, Object> verify(String token) {
//        String username;
        try {
            Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
            JwtParser parser = Jwts.parserBuilder().setSigningKey(key).build();
            Claims claims = parser.parseClaimsJws(token).getBody();
//            username = claims.get("username").toString();
//            System.out.println(claims.entrySet());
            Map<String, Object> map = new HashMap<>();
            for (Map.Entry m: claims.entrySet()) {
                map.put(m.getKey().toString(), m.getValue());
            }
            return map;
//            return claims.entrySet().stream()
//                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
