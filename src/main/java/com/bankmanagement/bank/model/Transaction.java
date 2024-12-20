package com.bankmanagement.bank.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@RequiredArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final LocalDate transDate;

    //Databasede isimle görünmesi için defaultta integer görünür
    @Enumerated(EnumType.STRING)
    private final TransactionType transactionType;

    private final BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    //JPA için boş constructor
    public Transaction() {
        this.transDate = null;
        this.transactionType = null;
        this.amount = null;
    }

    public Transaction(LocalDate transDate, TransactionType transactionType, BigDecimal amount, Account account) {
        this.transDate = transDate;
        this.transactionType = transactionType;
        this.amount = amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getAccount() {
        return account;
    }
}
