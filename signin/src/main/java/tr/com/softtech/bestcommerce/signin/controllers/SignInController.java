package tr.com.softtech.bestcommerce.signin.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.softtech.bestcommerce.signin.models.SignInResponse;
import tr.com.softtech.bestcommerce.signin.services.SignInService;

@RestController
@RequestMapping(SignInController.ENDPOINT)
@Api(produces = MediaType.APPLICATION_JSON_VALUE, tags = "Sign in")
public class SignInController {

    public static final String ENDPOINT = "/v1/signin";

    @Autowired
    private SignInService signInService;

    @CrossOrigin
    @ApiOperation("Sign in user")
    @PostMapping()
    public SignInResponse signIn() {
        return signInService.signIn();
    }

}
