package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.AccountDtoConverter;
import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Exception.AccountAlreadyExistException;
import com.bankmanagement.bank.Exception.AccountNotFoundException;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountDtoConverter converter;
    private final CustomerService customerService;

    public AccountService(AccountRepository accountRepository, AccountDtoConverter converter, CustomerService customerService) {
        this.accountRepository = accountRepository;
        this.converter = converter;
        this.customerService = customerService;
    }


    public Customer getAccountCustomerByCustomerId(Long id){
        return customerService.findCustomerById(id);
    }

    public List<Account> findAllAccount(){
        return accountRepository.findAll();
    }


    public AccountDto addAccount(Account account){
        List<Account> accounts=findAllAccount();
        if(accounts.contains(account)){
            throw new AccountAlreadyExistException("Hesap Zaten Mevcut Eklenilemedi "+account);
        }
        Account account1=accountRepository.save(account);
        return converter.convertToAccountDto(account1);
    }

    public Account findAccountById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(()->new AccountNotFoundException("Account Not Found By Id : "+id));
    }

    public AccountDto getAccountById(Long id){
        return converter.convertToAccountDto(findAccountById(id));
    }
}
