package com.example.jpatwodb.service;

import com.example.jpatwodb.dao.lrmdb.AccountInfoRepository;
import com.example.jpatwodb.model.lrmdb.AccountInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountInfoService {

    @Autowired
    AccountInfoRepository accountInfoRepository;

    public List<AccountInfo> getAccountInfo() {
        return accountInfoRepository.findAll();
    }
}
