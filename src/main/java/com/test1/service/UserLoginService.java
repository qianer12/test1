package com.test1.service;

import com.test1.entity.User;

public interface UserLoginService {

    User selectUser(String username, String password);

    int addUser(String username, String password, int age);

    void outLogin(String username);
}
