package tr.com.softtech.bestcommerce.signin.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;
import tr.com.softtech.bestcommerce.signin.entities.User;
import tr.com.softtech.bestcommerce.signin.exceptions.NotFoundException;
import tr.com.softtech.bestcommerce.signin.models.Credentials;
import tr.com.softtech.bestcommerce.signin.services.SignInService;

import javax.servlet.http.HttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class SignInControllerTest {

    @Autowired
    private SignInController signInController;

    @MockBean
    private SignInService signInService;

    @Mock
    private Credentials credentials;

    @Mock
    private HttpServletResponse response;

    @Mock
    private UserDto userDto;

    @Test
    public void whenValidCredentials_thenUserShouldAuthenticated() throws Exception {
        when(signInService.signIn(credentials))
                .thenReturn(userDto);

        UserDto found = signInController.signIn(credentials, response);

        assertThat(found).isEqualTo(userDto);
    }

    @Test()
    public void whenCredentialsNotValid_thenShouldThrowNotFoundException() {
        when(signInService.signIn(credentials))
                .thenThrow(new NotFoundException(User.class, "email"));

        Throwable thrown = assertThrows(NotFoundException.class,
                () -> {
                    signInController.signIn(credentials, response);
                });

        assertThat(thrown.getMessage()).isEqualTo("User:email");
    }

}
