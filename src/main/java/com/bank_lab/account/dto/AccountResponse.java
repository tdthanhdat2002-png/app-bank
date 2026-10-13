package com.bank_lab.account.dto;

import com.bank_lab.entity.Account;

public record AccountResponse(
        Long id,
        String accountNumber,
        String ownerName,
        Long balance,
        String currency,
        String status
) {
    public static AccountResponse fromEntity(Account account){
        return new AccountResponse(
                account.getId(),
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance(),
                account.getCurrency(),
                account.getStatus()
        );
    }
}
