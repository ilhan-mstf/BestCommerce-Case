package tr.com.softtech.bestcommerce.signin.mappers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tr.com.softtech.bestcommerce.signin.dtos.UserDto;
import tr.com.softtech.bestcommerce.signin.entities.User;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void whenNonNullUser_thenShouldReturnUserDto() {
        User user = new User();
        user.setEmail("email");
        user.setId(1L);
        user.setName("name");
        user.setPassword("pass");

        UserDto userDto = userMapper.entityToDto(user);

        assertThat(userDto.getEmail()).isEqualTo(user.getEmail());
        assertThat(userDto.getName()).isEqualTo(user.getName());
    }

    @Test
    public void whenNullUser_thenShouldReturnNull() {
        UserDto userDto = userMapper.entityToDto(null);

        assertThat(userDto).isNull();
    }
}
