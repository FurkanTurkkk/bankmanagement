package com.bankmanagement.bank.service;

import com.bankmanagement.bank.converter.AccountDtoConverter;
import com.bankmanagement.bank.dto.AccountDto;
import com.bankmanagement.bank.dto.CustomerAccountDto;
import com.bankmanagement.bank.exception.AccountAlreadyExistException;
import com.bankmanagement.bank.exception.AccountNotFoundException;
import com.bankmanagement.bank.exception.NotEnoughMoneyException;
import com.bankmanagement.bank.model.Account;
import com.bankmanagement.bank.model.Customer;
import com.bankmanagement.bank.model.Transaction;
import com.bankmanagement.bank.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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

    @Transactional
    public AccountDto addAccount(Account account){
        List<Account> accounts=findAllAccount();
        if(accounts.contains(account)){
            throw new AccountAlreadyExistException("Hesap Zaten Mevcut Eklenilemedi "+account);
        }
        Account account1=accountRepository.save(account);
        Customer customer=account1.getCustomer();
        customer.getAccounts().add(account1);
        return converter.convertToAccountDto(account1);
    }

    public Account findAccountByAccountId(Long id){
        return accountRepository.findById(id)
                .orElseThrow(()->new AccountNotFoundException("Account Not Found By Id : "+id));
    }

    public Set<Account> findAccountByCustomerTc(String tc){
        Customer customer=customerService.findCustomerByTc(tc);
        if(customer.getAccounts().isEmpty()){
            throw new AccountNotFoundException("Kullanıcıya Ait Hesap Bulunamadı...");
        }
        return accountRepository.findByCustomerId(customer.getId());
    }

    public AccountDto getAccountByAccountId(Long id){
        return converter.convertToAccountDto(findAccountByAccountId(id));
    }

    @Transactional
    public Set<CustomerAccountDto> getAccountByCustomerTc(String tc){
        return findAccountByCustomerTc(tc).stream()
                .map(converter::convertToCustomerAccountDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteAccountById(Long id){
        Account account=findAccountByAccountId(id);
        account.getCustomer().getAccounts().remove(account);
        accountRepository.deleteById(id);
    }

    public void upgradeAccountBalance(Account account,Transaction transaction){
        BigDecimal balanceOfBeforeTransaction=account.getBalance();
        BigDecimal balanceOfAfterTransaction;
        if(transaction.getTransactionType().equals("EFT")){
            if(account.getBalance().compareTo(transaction.getAmount()) < 0){
                throw new NotEnoughMoneyException("Yetesiz Bakiye");
            }else {
                balanceOfAfterTransaction=balanceOfBeforeTransaction.subtract(transaction.getAmount());
                Account registeredAccount=findAccountByAccountId(account.getId());
                accountRepository.saveBalance(registeredAccount,balanceOfAfterTransaction);
            }
        }
        else if(transaction.getTransactionType().equals("DEPOSIT")){
            balanceOfAfterTransaction=balanceOfBeforeTransaction.add(transaction.getAmount());
            Account registeredAccount=findAccountByAccountId(account.getId());
            accountRepository.saveBalance(registeredAccount,balanceOfAfterTransaction);
        }
    }

}
