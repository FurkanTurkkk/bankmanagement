package com.bankmanagement.bank.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class AccountDto {
    private BigDecimal balance;
    private LocalDate creationDate;
    private Set<TransactionDto> transactionDtos;

    public AccountDto() {
    }

    public AccountDto(BigDecimal balance, LocalDate creationDate, Set<TransactionDto> transactionDtos) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.transactionDtos = transactionDtos;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public Set<TransactionDto> getTransactionDtos() {
        return transactionDtos;
    }
}
