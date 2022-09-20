package com.example.jpatwodb.model.testdb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_id", length=20)
    private String userId;
    @Column(name="user_name", length=30)
    private String userName;
    @Column(name="email", length=30)
    private String email;
    @Column(name="verified", length=1)
    private Integer verified;
}