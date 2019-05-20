package com.test1.service;

import com.test1.entity.Account;

public interface AccountService {

    /**
     * 转账
     * @param fromUserId
     * @param toUserId
     * @param account
     */
    void transferAccounts(Account fromUserAccount,Account toUserAccount,float account);

    void update(Account account);

    Account findByName(String username);

    Account findById(int id);
}
