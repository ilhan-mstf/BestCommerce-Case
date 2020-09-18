package tr.com.softtech.bestcommerce.signin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tr.com.softtech.bestcommerce.signin.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);
}
