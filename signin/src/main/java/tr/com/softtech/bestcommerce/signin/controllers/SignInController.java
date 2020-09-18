package tr.com.softtech.bestcommerce.signin.controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;
import tr.com.softtech.bestcommerce.signin.models.Credentials;
import tr.com.softtech.bestcommerce.signin.security.JwtConstants;
import tr.com.softtech.bestcommerce.signin.services.SignInService;

import javax.servlet.http.HttpServletResponse;

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
    public UserDto signIn(
            @RequestBody final Credentials credentials,
            HttpServletResponse response
    ) {
        UserDto userDto = signInService.signIn(credentials);
        addJwtHeaders(response, credentials);

        return userDto;
    }

    private void addJwtHeaders(
            HttpServletResponse response, Credentials credentials
    ) {
        response.setHeader(
                JwtConstants.HEADER_JWT_SUBJECT, credentials.getEmail());
        response.setHeader(
                JwtConstants.HEADER_JWT_REMEMBER, credentials.getRemember());
    }

}
