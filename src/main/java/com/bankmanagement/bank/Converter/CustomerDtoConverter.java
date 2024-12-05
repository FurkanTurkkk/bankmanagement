package com.bankmanagement.bank.Converter;

import com.bankmanagement.bank.Dto.AccountCustomerDto;
import com.bankmanagement.bank.Dto.CustomerDto;
import com.bankmanagement.bank.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    private final AccountDtoConverter converter;

    public CustomerDtoConverter(AccountDtoConverter converter) {
        this.converter = converter;
    }

    public CustomerDto convertToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.geteMailAddress(),
                customer.getTCkn()
        );
    }

    public AccountCustomerDto convertToAccountCustomerDto(Customer customer){
        return new AccountCustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.geteMailAddress(),
                customer.getTCkn(),
                customer.getAccounts().stream()
                        .map(converter::convertToAccountDto)
                        .collect(Collectors.toSet())
        );
    }
}
