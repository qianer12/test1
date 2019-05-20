package com.test1.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Account implements Serializable {

    /**
     * id 编号
     */
    @Id
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 余额
     */
    private float balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
