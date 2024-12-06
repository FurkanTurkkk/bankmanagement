package com.bankmanagement.bank.dto;

import java.util.Set;

public class AccountCustomerDto {
    private String firstName;
    private String lastName;
    private String eMailAddress;
    private String TCkn;
    private Set<AccountDto> accountDtos;

    public AccountCustomerDto() {
    }

    public AccountCustomerDto(String firstName, String lastName, String eMailAddress, String TCkn, Set<AccountDto> accountDtos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMailAddress = eMailAddress;
        this.TCkn = TCkn;
        this.accountDtos = accountDtos;
    }
}
