package tr.com.softtech.bestcommerce.apigateway.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class JwtGeneratorTest {

    @Autowired
    private JwtGenerator jwtGenerator;

    @Autowired
    private JwtValidator jwtValidator;

    @Test
    public void shouldGenerate_ValidJwt() {
        JwtDetails jwtDetails = new JwtDetails();
        jwtDetails.setExpiration(100000);
        jwtDetails.setSubject("hede");

        String token = jwtGenerator.generate(jwtDetails);

        boolean val =  jwtValidator.validate(token);

        assertThat(val).isTrue();
    }
}
