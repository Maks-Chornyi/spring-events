package com.makschornyi.springevents.service;

import com.makschornyi.springevents.model.User;
import com.makschornyi.springevents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(User user) {
        return this.userRepository.save(user);
    }

    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found id: " + id));
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }


}
