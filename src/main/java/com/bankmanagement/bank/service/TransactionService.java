package com.bankmanagement.bank.service;

import com.bankmanagement.bank.converter.TransactionDtoConverter;
import com.bankmanagement.bank.dto.TransactionDto;
import com.bankmanagement.bank.model.Account;
import com.bankmanagement.bank.model.Transaction;
import com.bankmanagement.bank.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final TransactionDtoConverter converter;

    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, TransactionDtoConverter converter) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.converter = converter;
    }

    public Account findAccountByAccountId(Long id){
        return accountService.findAccountByAccountId(id);
    }

    @Transactional
    public TransactionDto addTransaction(Transaction transaction, Account account){
        account.getTransactions().add(transaction);
        return converter.convertToTransactionDto(transactionRepository.save(transaction));
    }

}
