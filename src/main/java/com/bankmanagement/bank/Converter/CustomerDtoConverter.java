package com.bankmanagement.bank.Converter;

import com.bankmanagement.bank.Dto.AccountCustomerDto;
import com.bankmanagement.bank.Dto.CustomerDto;
import com.bankmanagement.bank.Model.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {

    public CustomerDto convertToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.geteMailAddress(),
                customer.gettckn()
        );
    }

}
