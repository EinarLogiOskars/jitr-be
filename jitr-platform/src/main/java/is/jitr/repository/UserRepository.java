package is.jitr.repository;

import is.jitr.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Custom database queries can be define here
    Optional<User> findByUsername(String username);
}
