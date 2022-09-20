package com.example.jpatwodb.service;

import com.example.jpatwodb.dao.testdb.UserRepository;
import com.example.jpatwodb.model.testdb.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
