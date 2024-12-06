package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.AccountDtoConverter;
import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Dto.CustomerAccountDto;
import com.bankmanagement.bank.Exception.AccountAlreadyExistException;
import com.bankmanagement.bank.Exception.AccountNotFoundException;
import com.bankmanagement.bank.Exception.CustomerNotFoundException;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

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

}
