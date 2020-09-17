package tr.com.softtech.bestcommerce.signin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tr.com.softtech.bestcommerce.signin.models.SignInResponse;
import tr.com.softtech.bestcommerce.signin.services.SignInService;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    @Override
    public SignInResponse signIn() {
        SignInResponse response = new SignInResponse();
        response.setMsg("success");
        response.setToken("1234");

        return response;
    }
}
