package com.makschornyi.springevents.controller;

import com.makschornyi.springevents.event.publisher.UserTypeSetterPublisher;
import com.makschornyi.springevents.model.User;
import com.makschornyi.springevents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserRepository userRepository;
    private final UserTypeSetterPublisher publisher;

    @Autowired
    public UserController(UserRepository userRepository, UserTypeSetterPublisher publisher) {
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        final User newUser = userRepository.createNewUser(user);
        publisher.publishCustomEvent(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
