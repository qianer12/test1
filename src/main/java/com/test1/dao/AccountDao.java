package com.test1.dao;

import com.test1.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AccountDao {

    Account findById(int id);

    Account findByName(String username);

    void update(Account account);
}
