package com.example.jpatwodb.dao.lrmdb;

import com.example.jpatwodb.model.lrmdb.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, String> {
}
