package com.bankmanagement.bank.converter;

import com.bankmanagement.bank.dto.TransactionDto;
import com.bankmanagement.bank.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {
    public TransactionDto convertToTransactionDto(Transaction transaction){
        return new TransactionDto(transaction.getTransDate(),transaction.getTransactionType(),transaction.getAmount());
    }
}

