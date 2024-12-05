package com.bankmanagement.bank.UserRequest;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.TransactionType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CreateForTransaction {

    private final Account account;
    private final LocalDate transDate;
    private final TransactionType transactionType;
    private final BigDecimal amount;

    public CreateForTransaction() {
        this.account = null;
        this.transDate = LocalDate.now();
        this.transactionType = null;
        this.amount = null;
    }

    public CreateForTransaction(Account account, TransactionType transactionType, BigDecimal amount) {
        this.account = account;
        this.transDate = LocalDate.now();
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
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
}
