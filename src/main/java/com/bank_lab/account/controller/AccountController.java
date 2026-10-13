package com.bank_lab.account.controller;


import com.bank_lab.account.dto.AccountResponse;
import com.bank_lab.account.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
    private  final AccountService accountService;

    public  AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponse> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    //GET /api/v1/accounts/{id}
    @GetMapping("/{id}")
    public AccountResponse getAccountById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }


    //GET /api/v1/accounts/{1}/balance
    @GetMapping("/{id}/balance")
    public Map<String, Object> getAccountBalance(@PathVariable("id") Long id){
        AccountResponse account = accountService.getAccountById(id);

        return Map.of(
                "accountNumber", account.accountNumber(),
                "balance", account.balance(),
                "currency", account.currency()
        );
    }
}
