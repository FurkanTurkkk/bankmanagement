package com.bankmanagement.bank.Converter;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Model.Account;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountDtoConverter {

    private final TransactionDtoConverter transactionDtoConverter;

    public AccountDtoConverter(TransactionDtoConverter transactionDtoConverter) {
        this.transactionDtoConverter = transactionDtoConverter;
    }

    public AccountDto convertToAccountDto(Account account){
        return new AccountDto(
                account.getBalance(),
                account.getCreationDate(),
                account.getTransactions().stream()
                        .map(transactionDtoConverter::convertToTransactionDto)
                        .collect(Collectors.toSet()));
    }
}
