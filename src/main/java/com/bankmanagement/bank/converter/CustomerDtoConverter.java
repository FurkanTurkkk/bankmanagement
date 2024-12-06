package com.bankmanagement.bank.converter;

import com.bankmanagement.bank.dto.CustomerDto;
import com.bankmanagement.bank.model.Customer;
import org.springframework.stereotype.Component;

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
