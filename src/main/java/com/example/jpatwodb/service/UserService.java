package com.example.jpatwodb.service;

import com.example.jpatwodb.dao.testdb.UserRepository;
import com.example.jpatwodb.model.testdb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findById(String username) {
        return userRepository.findById(username).orElse(null);
    }

    public void addUser(User user) {
        PasswordEncoder pe = new BCryptPasswordEncoder();
        user.setPw(pe.encode(user.getPw()));
        System.out.println(user);
        userRepository.save(user);
    }
}
