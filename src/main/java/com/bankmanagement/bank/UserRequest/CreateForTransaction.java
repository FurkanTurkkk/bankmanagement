package com.bankmanagement.bank.UserRequest;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.TransactionType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class CreateForTransaction {

    private final Long account_id;
    private final LocalDate transDate;
    private final TransactionType transactionType;
    private final BigDecimal amount;

    public CreateForTransaction() {
        this.account_id = null;
        this.transDate = LocalDate.now();
        this.transactionType = null;
        this.amount = null;
    }

    public CreateForTransaction(Long account_id, TransactionType transactionType, BigDecimal amount) {
        this.account_id = account_id;
        this.transDate = LocalDate.now();
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public Long getAccount_id() {
        return account_id;
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
