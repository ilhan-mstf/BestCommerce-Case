package tr.com.softtech.bestcommerce.signin.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;
import tr.com.softtech.bestcommerce.signin.entities.User;
import tr.com.softtech.bestcommerce.signin.exceptions.NotFoundException;
import tr.com.softtech.bestcommerce.signin.mappers.UserMapper;
import tr.com.softtech.bestcommerce.signin.models.Credentials;
import tr.com.softtech.bestcommerce.signin.repositories.UserRepository;
import tr.com.softtech.bestcommerce.signin.services.SignInService;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto signIn(Credentials credentials) {
        User user = userRepository
                .findByEmailAndPassword(credentials.getEmail(), credentials.getPassword())
                .orElseThrow(() -> new NotFoundException(User.class, credentials.getEmail()));

        return userMapper.entityToDto(user);
    }
}
