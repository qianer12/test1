package com.test1.service.impl;

import com.test1.dao.UserDao;
import com.test1.entity.User;
import com.test1.service.UserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserDao userDao;

    //用户查找
    @Cacheable(cacheNames="user", key="'username_'+#username")
    public User selectUser(String username, String password){
        User user = userDao.selectUser(username,password);
        System.out.println("查询user，输出此句代表没有走缓存");
        return user;
    }

    //新增用户
    public int addUser(String username, String password, int age){
        return userDao.addUser(username,password,age);
        //return usermapper.adduser1(username,password,age);     //对应sql语句中的第二种注册方式
    }

    @CacheEvict(cacheNames="user", key="'username_'+#username",condition="#username!=''")
    public void outLogin(String username) {

    }
}
