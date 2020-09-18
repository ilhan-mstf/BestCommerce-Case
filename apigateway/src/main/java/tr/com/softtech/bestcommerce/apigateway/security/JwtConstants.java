package tr.com.softtech.bestcommerce.apigateway.security;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtConstants {

    public static final String HEADER_JWT = "X-JWT";
    public static final String HEADER_JWT_SUBJECT = "X-JWT-Subject";
    public static final String HEADER_JWT_REMEMBER = "X-JWT-Remember";

    @Getter
    @Value("${jwt.shortExpiration}")
    private long shortExpiration;

    @Getter
    @Value("${jwt.longExpiration}")
    private long longExpiration;

    @Getter
    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
}
