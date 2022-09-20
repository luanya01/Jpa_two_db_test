package com.example.jpatwodb.model.lrmdb;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "account_info")
public class AccountInfo {

    @Id
    @Column(name="projectid", length=10)
    private String projectId;
    @Column(name="exchangetype", length=15)
    private String exchangeType;
    @Column(name="status", length=1)
    private String status;
}