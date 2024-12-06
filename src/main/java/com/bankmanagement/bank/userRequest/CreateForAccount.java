package com.bankmanagement.bank.userRequest;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@Component
public class CreateForAccount {

    private final Long customer_id;
    private final LocalDate creationDate;
    private final BigDecimal balance=BigDecimal.ZERO;

    public CreateForAccount() {
        this.customer_id=0L;
        this.creationDate=LocalDate.now();
    }

    public CreateForAccount(Long customerId) {
        customer_id = customerId;
        this.creationDate=LocalDate.now();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Long getCustomer_id() {
        return customer_id;
    }
}
