package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    
    @DeleteMapping("/clear")
    public String clearUsers() {
        userRepository.deleteAll();
        return "All data cleared";
    }
}
