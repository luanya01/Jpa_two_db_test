package com.example.jpatwodb.model.testdb;

import com.example.jpatwodb.model.StringListConverter;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_name", length=30)
    private String username;

    @Column(name="pw", length=200)
    private String pw;

    @Column(name="authority", length=200)
    @Convert(converter = StringListConverter.class)
    private List<String> authority;

    @Column(name="email", length=30)
    private String email;

    @Column(name="verified", length=1)
    private Integer verified;
}