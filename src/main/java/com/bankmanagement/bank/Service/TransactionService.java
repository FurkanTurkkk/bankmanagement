package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.TransactionDtoConverter;
import com.bankmanagement.bank.Dto.TransactionDto;
import com.bankmanagement.bank.Model.Transaction;
import com.bankmanagement.bank.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionDtoConverter converter;

    public TransactionService(TransactionRepository transactionRepository, TransactionDtoConverter converter) {
        this.transactionRepository = transactionRepository;
        this.converter = converter;
    }

    public TransactionDto addTransaction(Transaction transaction){
        return converter.convertToTransactionDto(transactionRepository.save(transaction));
    }

}
