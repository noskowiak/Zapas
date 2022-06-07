package pl.zapas.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zapas.entity.User;
import pl.zapas.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping
    private ResponseEntity<List<User>> getAllUsers() {return ResponseEntity.ok(userService.findAll());}

    @GetMapping("/{id}")
    private ResponseEntity<User> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PostMapping
    private ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    

}
