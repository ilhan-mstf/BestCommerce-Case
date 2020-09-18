package tr.com.softtech.bestcommerce.signin.mappers;

import org.springframework.stereotype.Component;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;
import tr.com.softtech.bestcommerce.signin.entities.User;

@Component
public class UserMapper {

    public UserDto entityToDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        return userDto;
    }
}
