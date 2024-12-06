package com.bankmanagement.bank.Converter;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Dto.CustomerAccountDto;
import com.bankmanagement.bank.Model.Account;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;
    private final CustomerDtoConverter customerDtoConverter;

    public AccountDtoConverter(TransactionDtoConverter transactionDtoConverter, CustomerDtoConverter customerDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
        this.customerDtoConverter = customerDtoConverter;
    }


    public AccountDto convertToAccountDto(Account account) {
        if (account.getTransactions() == null) {
            return new AccountDto(
                    account.getBalance(),
                    account.getCreationDate(),
                    new HashSet<>());
        }
        return new AccountDto(
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::convertToTransactionDto)
                        .collect(Collectors.toSet())
        );
    }

    public CustomerAccountDto convertToCustomerAccountDto(Account account){
        if(account.getTransactions()==null){
            return new CustomerAccountDto(
                    customerDtoConverter.convertToCustomerDto(account.getCustomer()),
                    account.getBalance(),
                    account.getCreationDate(),
                    new HashSet<>()
            );
        }
        return new CustomerAccountDto(
                customerDtoConverter.convertToCustomerDto(account.getCustomer()),
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::convertToTransactionDto)
                        .collect(Collectors.toSet())
        );
    }

}
