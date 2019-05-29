package com.test1.service.impl;

import com.test1.dao.AccountDao;
import com.test1.entity.Account;
import com.test1.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    //@Transactional
    public void transferAccounts(Account fromUserAccount, Account toUserAccount, float account) {
        fromUserAccount.setBalance(fromUserAccount.getBalance()-account);
        accountDao.update(fromUserAccount); // fromUser扣钱

        toUserAccount.setBalance(toUserAccount.getBalance()+account);
        //假设转账的时候假如出现异常，业务类或业务方法中没有使用@Transactional控制事务，则会出现钱转出了，收钱人没有收到的情况
        int zero = 1/0;
        accountDao.update(toUserAccount); // toUser加钱
    }

    @Override
    public void update(Account account) {
        accountDao.update(account);
    }

    @Override
    public Account findByName(String username) {
        return accountDao.findByName(username);
    }

    @Override
    public Account findById(int id) {
        return accountDao.findById(id);
    }
}
