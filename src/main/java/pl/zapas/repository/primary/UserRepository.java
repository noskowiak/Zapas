package pl.zapas.repository.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.primary.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
}
