package com.bank_lab.account.repository;


import com.bank_lab.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByAccountNumber(
            String  accountNumber
    );
}
