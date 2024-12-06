package com.bankmanagement.bank.dto;

import com.bankmanagement.bank.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionDto {

    private LocalDate transDate;
    private TransactionType transactionType;
    private BigDecimal amount;

    public TransactionDto() {
    }

    public TransactionDto(LocalDate transDate, TransactionType transactionType, BigDecimal amount) {

        this.transDate = transDate;
        this.transactionType = transactionType;
        this.amount = amount;
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
