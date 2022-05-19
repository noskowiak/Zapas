package pl.zapas.web.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zapas.entity.User;
import pl.zapas.repository.UserRepository;
import pl.zapas.service.UserService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    private static final User USER = new User(1L, "Jan", "Kowalski", "jan@kowalski.com", "pass1", true);


    @Mock
    private UserRepository userRepository;


    @InjectMocks
    private UserService userService;

    @Test
    void shouldReturnUserById() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(USER));
        //when
        User result = userService.findUserById(1L);
        //then
        assertEquals(USER, result); //junit

    }

    @Test
    void shouldThrowExceptionWhenUserNoExist() {
        //given
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        //when & then
        assertThrows(NoSuchElementException.class,
                () -> userService.findUserById(2L)); // junit
    }


}