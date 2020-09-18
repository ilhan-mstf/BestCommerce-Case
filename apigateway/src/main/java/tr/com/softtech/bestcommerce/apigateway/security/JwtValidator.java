package tr.com.softtech.bestcommerce.apigateway.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    @Autowired
    private JwtConstants jwtConstants;

    public boolean validate(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(jwtConstants.getKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
        }
        return false;
    }
}
