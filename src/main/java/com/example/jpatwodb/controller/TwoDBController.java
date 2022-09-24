package com.example.jpatwodb.controller;

import com.example.jpatwodb.model.testmaindb.AccountInfo;
import com.example.jpatwodb.model.testdb.User;
import com.example.jpatwodb.service.AccountInfoService;
import com.example.jpatwodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class TwoDBController {

    @Autowired
    private AccountInfoService accountInfoService;
    @Autowired
    private UserService userService;

    @GetMapping("/accounts")
    @Transactional("testmainTransactionManager")
    public List<AccountInfo> getAccountInfo() {
        return accountInfoService.getAccountInfo();
    }

    @GetMapping("/users")
    @Transactional("testTransactionManager")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/users/add")
    @Transactional("testTransactionManager")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        try {
            userService.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("add user faile.");
        }
        return ResponseEntity.status(HttpStatus.OK).body("add user successful.");
    }

}
