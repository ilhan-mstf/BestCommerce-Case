package tr.com.softtech.bestcommerce.signin.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Credentials {

    private String email;
    private String password;
    private String remember;
}
