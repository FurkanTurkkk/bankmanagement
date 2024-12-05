package com.bankmanagement.bank.UserRequest;

import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Model.Transaction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;


@Component
public class CreateForAccount {

    private final Customer customer;
    private final LocalDate creationDate;
    private final BigDecimal balance=BigDecimal.ZERO;

    public CreateForAccount() {
        this.customer=null;
        this.creationDate=LocalDate.now();
    }



    public CreateForAccount(Customer customer) {
        this.customer = customer;
        this.creationDate=LocalDate.now();
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }
}
