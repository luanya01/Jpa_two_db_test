package com.example.jpatwodb.dao.testmaindb;

import com.example.jpatwodb.model.testmaindb.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, String> {
}
