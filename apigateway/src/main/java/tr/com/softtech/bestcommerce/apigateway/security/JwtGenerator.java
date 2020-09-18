package tr.com.softtech.bestcommerce.apigateway.security;

import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtGenerator {

    @Autowired
    private JwtConstants jwtTokenConstants;

    public String generate(JwtDetails details) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(details.getSubject())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + details.getExpiration()))
                .signWith(jwtTokenConstants.getKey())
                .compact();
    }
}
