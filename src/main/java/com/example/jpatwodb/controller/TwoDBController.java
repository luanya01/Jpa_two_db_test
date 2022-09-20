package com.example.jpatwodb.controller;

import com.example.jpatwodb.model.lrmdb.AccountInfo;
import com.example.jpatwodb.model.testdb.User;
import com.example.jpatwodb.service.AccountInfoService;
import com.example.jpatwodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableTransactionManagement
public class TwoDBController {

    @Autowired
    private AccountInfoService accountInfoService;
    @Autowired
    private UserService userService;

    @GetMapping("/getallai")
    @Transactional("lrmTransactionManager")
    public List<AccountInfo> getAccountInfo() {
        return accountInfoService.getAccountInfo();
    }

    @GetMapping("/getalluser")
    @Transactional("testTransactionManager")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
