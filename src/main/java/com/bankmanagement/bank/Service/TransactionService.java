package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.TransactionDtoConverter;
import com.bankmanagement.bank.Dto.TransactionDto;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.Transaction;
import com.bankmanagement.bank.Repository.TransactionRepository;
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
