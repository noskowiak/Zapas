package pl.zapas.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.User;
import pl.zapas.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService  {

    private final UserRepository userRepository;




    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public User save(User user) {
            return userRepository.save(user);


    }
    // TODO: 17.05.2022  saveUser, activeUser, deactivateUser, updateName, updateLastName

}
