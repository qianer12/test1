package com.test1.controller;

import com.test1.entity.Account;
import com.test1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/transfer")
    public String transferAccounts(@RequestParam("fromUser")String formUser, @RequestParam("toUser")String toUser, @RequestParam("account")float account){
        Account formUserAccount = accountService.findByName(formUser);
        Account toUserAccount = accountService.findByName(toUser);
        try {
            accountService.transferAccounts(formUserAccount, toUserAccount, account);
            return "ok";
        }catch(Exception e){
            return "no";
        }
    }

}
