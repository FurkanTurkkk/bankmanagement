package com.bankmanagement.bank.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;


@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private final String accountNumber= UUID.randomUUID().toString().replace("-","").substring(0,12);


    private BigDecimal balance;
    private LocalDate creationDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;


    @OneToMany(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    private Set<Transaction> transactions= new HashSet<>();

    public Account() {
    }

    public Account(BigDecimal balance, LocalDate creationDate, Customer customer) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
    }

    public Account(BigDecimal balance, LocalDate creationDate, Customer customer, Set<Transaction> transactions) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.customer = customer;
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    public Long getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }
}
