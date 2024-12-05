package com.bankmanagement.bank.ServiceTest;

import com.bankmanagement.bank.Converter.AccountDtoConverter;
import com.bankmanagement.bank.Converter.TransactionDtoConverter;
import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Dto.TransactionDto;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Model.Transaction;
import com.bankmanagement.bank.Model.TransactionType;
import com.bankmanagement.bank.Repository.AccountRepository;
import com.bankmanagement.bank.Service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
/*
class AccountServiceTest {

    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;
    Customer mockCustomer=new Customer("mockito","132123","Furkan","Türk","fuurkan.tuurk@gmail.com","123123");
    private org.mockito.MockitoAnnotations MockitoAnnotations;


    @BeforeEach
     void setUp(){
        MockitoAnnotations.openMocks(this);
        TransactionDtoConverter converterMockTransaction=new TransactionDtoConverter();
        AccountDtoConverter converterMockAccount=new AccountDtoConverter(converterMockTransaction);
        accountService = new AccountService(accountRepository,converterMockAccount);

    }
    @Test
    void createNewAccount(){
        Account mockAccount=new Account(new BigDecimal("123123"), LocalDate.now(),mockCustomer,new HashSet<>());
        Transaction transaction=new Transaction(LocalDate.now(), TransactionType.EFT,new BigDecimal("123123"),mockAccount);
        Transaction transaction1=new Transaction(LocalDate.now(),TransactionType.WITHDRAW,new BigDecimal("123123"),mockAccount);
        Set<Transaction> mockTransactions=new HashSet<>();
        mockTransactions.add(transaction);
        mockTransactions.add(transaction1);
        TransactionDtoConverter converter=new TransactionDtoConverter();

        Set<TransactionDto> transactionDtos= mockTransactions.stream().map(converter::convertToTransactionDto).collect(Collectors.toSet());

        AccountDto mockAccountDto=new AccountDto(new BigDecimal("123"),LocalDate.now(),transactionDtos);
        when(accountRepository.save(any(Account.class))).thenReturn(mockAccount);

        AccountDto result=accountService.addAccount(mockAccount);

        assertNotNull(result);
        assertEquals(new BigDecimal("123123"),result.getBalance());

        verify(accountRepository,times(1)).save(any(Account.class));
    }

}

 */