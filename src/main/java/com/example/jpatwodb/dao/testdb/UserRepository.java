package com.example.jpatwodb.dao.testdb;

import com.example.jpatwodb.model.testdb.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
