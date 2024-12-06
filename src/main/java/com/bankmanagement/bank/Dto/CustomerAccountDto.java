package com.bankmanagement.bank.Dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class CustomerAccountDto {
    private CustomerDto customerDto;
    private BigDecimal balance;
    private LocalDate creationDate;
    private Set<TransactionDto> transactionDtos;

    public CustomerAccountDto() {
    }

    public CustomerAccountDto(BigDecimal balance, LocalDate creationDate, Set<TransactionDto> transactionDtos) {
        this.balance = balance;
        this.creationDate = creationDate;
        this.transactionDtos = transactionDtos;
    }

    public CustomerAccountDto(CustomerDto customerDto, BigDecimal balance, LocalDate creationDate, Set<TransactionDto> transactionDtos) {
        this.customerDto = customerDto;
        this.balance = balance;
        this.creationDate = creationDate;
        this.transactionDtos = transactionDtos;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
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
