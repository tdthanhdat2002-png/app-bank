package com.bank_lab.entity;


import jakarta.persistence.*;

@Entity
@Table(name="accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(name = "account_number",
            nullable = false,
            unique = true,
            length = 30)
    private String accountNumber;

    @Column(name = "owner_name",
            nullable = false,
            length = 100)
    private String ownerName;

    @Column(nullable = false)
    private Long balance;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(nullable = false, length = 20)
    private String status;

    protected Account() {
        // Constructor required by JPA
    }

    public Account(
            String accountNumber,
            String ownerName,
            Long balance,
            String currency,
            String status) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
        this.currency = currency;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Long getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getStatus() {
        return status;
    }
}