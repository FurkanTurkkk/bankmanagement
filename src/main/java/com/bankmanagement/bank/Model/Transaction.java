package com.bankmanagement.bank.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    private final TransactionType transactionType;
    private final BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account",nullable = false)
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
