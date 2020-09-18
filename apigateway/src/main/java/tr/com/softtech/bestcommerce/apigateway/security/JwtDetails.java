package tr.com.softtech.bestcommerce.apigateway.security;

import lombok.Data;

@Data
public class JwtDetails {

    private String subject;
    private long expiration;
}
