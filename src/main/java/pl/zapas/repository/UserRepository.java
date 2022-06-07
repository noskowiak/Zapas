package pl.zapas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.zapas.entity.User;



public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);
}
