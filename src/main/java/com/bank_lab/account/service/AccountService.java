
package com.bank_lab.account.service;

import com.bank_lab.account.dto.AccountResponse;
//import com.bank_lab.account.entity.Account;
import com.bank_lab.account.repository.AccountRepository;

import com.bank_lab.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountResponse> getAllAccounts() {

        return accountRepository.findAll()
                .stream()
                .map(AccountResponse::fromEntity)
                .toList();
    }

    public AccountResponse getAccountById(Long id) {

        com.bank_lab.entity.Account account = accountRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Account not found"
                        )
                );

        return AccountResponse.fromEntity(account);
    }
}
