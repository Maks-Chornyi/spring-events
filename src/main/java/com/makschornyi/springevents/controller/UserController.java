package com.makschornyi.springevents.controller;

import com.makschornyi.springevents.event.publisher.UserTypeSetterPublisher;
import com.makschornyi.springevents.model.User;
import com.makschornyi.springevents.repository.UserRepository;
import com.makschornyi.springevents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;
    private final UserTypeSetterPublisher publisher;

    @Autowired
    public UserController(UserService userService, UserTypeSetterPublisher publisher) {
        this.userService = userService;
        this.publisher = publisher;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {
        final User newUser = userService.createNewUser(user);
        publisher.publishCustomEvent(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }
}
