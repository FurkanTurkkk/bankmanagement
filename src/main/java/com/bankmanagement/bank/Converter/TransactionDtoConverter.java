package com.bankmanagement.bank.Converter;

import com.bankmanagement.bank.Dto.TransactionDto;
import com.bankmanagement.bank.Model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convertToTransactionDto(Transaction transaction){
        return new TransactionDto(transaction.getTransDate(),transaction.getTransactionType(),transaction.getAmount());
    }
}

