package tr.com.softtech.bestcommerce.apigateway.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import tr.com.softtech.bestcommerce.apigateway.security.JwtConstants;
import tr.com.softtech.bestcommerce.apigateway.security.JwtDetails;
import tr.com.softtech.bestcommerce.apigateway.security.JwtGenerator;

import java.util.List;
import java.util.Optional;

@Component
public class AddJwtFilter extends AbstractGatewayFilterFactory<AddJwtFilter.Config> {

    @Autowired
    private JwtGenerator jwtTokenGenerator;

    @Autowired
    private JwtConstants jwtConstants;

    public AddJwtFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) ->
            chain.filter(exchange)
                    .then(Mono.fromRunnable(() -> {
                        handleJwt(exchange);
                    }));
    }

    private void handleJwt(ServerWebExchange exchange) {
        ServerHttpResponse response = exchange.getResponse();
        if (response.getStatusCode().equals(HttpStatus.OK)) {
            addJwt(response);
        }
    }

    private void addJwt(ServerHttpResponse response) {
        Optional<JwtDetails> optionalJwtDetails = getJwtDetails(response);
        if (optionalJwtDetails.isPresent()) {
            response.getHeaders()
                    .add(JwtConstants.HEADER_JWT,
                            jwtTokenGenerator.generate(optionalJwtDetails.get()));
        }
    }

    private Optional<JwtDetails> getJwtDetails(ServerHttpResponse response) {
        JwtDetails jwtDetails = null;

        Optional<List<String>> optionalSubject = Optional
                .ofNullable(response.getHeaders()
                        .get(JwtConstants.HEADER_JWT_SUBJECT));
        Optional<List<String>> optionalRemember = Optional
                .ofNullable(response.getHeaders()
                        .get(JwtConstants.HEADER_JWT_REMEMBER));

        if (optionalRemember.isPresent()
                && optionalSubject.isPresent()) {

            jwtDetails = new JwtDetails();
            jwtDetails.setSubject(optionalSubject.get().get(0));
            if (optionalRemember.get().get(0).equals("true")) {
                jwtDetails.setExpiration(jwtConstants.getLongExpiration());
            } else {
                jwtDetails.setExpiration(jwtConstants.getShortExpiration());
            }
        }

        return Optional.ofNullable(jwtDetails);
    }

    public static class Config {
    }
}
