package tr.com.softtech.bestcommerce.apigateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import tr.com.softtech.bestcommerce.apigateway.security.JwtValidator;

import java.util.List;
import java.util.Optional;

@Component
public class ValidateJwtFilter extends AbstractGatewayFilterFactory<ValidateJwtFilter.Config> {

    @Autowired
    private JwtValidator jwtValidator;

    public ValidateJwtFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(ValidateJwtFilter.Config config) {
        return (exchange, chain) -> {
            if (!isAuthenticated(exchange)) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return chain.filter(exchange);
        };
    }

    private boolean isAuthenticated(ServerWebExchange exchange) {
        boolean authenticated = false;

        Optional<List<String>> authHeader =
                Optional.ofNullable(exchange.getRequest()
                        .getHeaders().get("Authorization"));
        if (authHeader.isPresent()) {
            String authorization = authHeader.get().get(0)
                    .replace("Bearer ", "");
            authenticated = jwtValidator.validate(authorization);
        }

        return authenticated;
    }

    public static class Config {
    }
}
