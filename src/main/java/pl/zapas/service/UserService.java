package pl.zapas.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zapas.entity.User;
import pl.zapas.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

}
