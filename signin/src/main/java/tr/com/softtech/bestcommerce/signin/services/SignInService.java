package tr.com.softtech.bestcommerce.signin.services;

import tr.com.softtech.bestcommerce.signin.models.Credentials;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;

public interface SignInService {

    UserDto signIn(Credentials credentials);
}
