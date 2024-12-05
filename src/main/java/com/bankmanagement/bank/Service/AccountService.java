package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.AccountDtoConverter;
import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Exception.AccountAlreadyExistException;
import com.bankmanagement.bank.Exception.AccountNotFoundException;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository,AccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.converter = converter;
    }

    public List<Account> findAllAccount(){
        return accountRepository.findAll();
    }


    public AccountDto addAccount(Account account){
        List<Account> accounts=findAllAccount();
        if(accounts.contains(account)){
            throw new AccountAlreadyExistException("Hesap Zaten Mevcut Eklenilemedi "+account);

        }
        return converter.convertToAccountDto(accountRepository.save(account));
    }

    public Account findAccountById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(()->new AccountNotFoundException("Account Not Found By Id : "+id));
    }

    public AccountDto getAccountById(Long id){
        return converter.convertToAccountDto(findAccountById(id));
    }
}
