package com.bankmanagement.bank.controller;

import com.bankmanagement.bank.dto.AccountDto;
import com.bankmanagement.bank.dto.CustomerAccountDto;
import com.bankmanagement.bank.model.Account;
import com.bankmanagement.bank.model.Customer;
import com.bankmanagement.bank.service.AccountService;
import com.bankmanagement.bank.userRequest.CreateForAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody CreateForAccount request){
        Customer customer=accountService.getAccountCustomerByCustomerId(request.getCustomer_id());
        return ResponseEntity.ok(accountService.addAccount(new Account(
                request.getBalance(),
                request.getCreationDate(),
                customer
        )));
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> getAccountByAccountId(@PathVariable("account_id") Long id){
        return ResponseEntity.ok(accountService.getAccountByAccountId(id));
    }

    @GetMapping("/tc/{customer_tc}")
    public ResponseEntity<Set<CustomerAccountDto>> getAccountByCustomerTckn(@PathVariable("customer_tc") String tckn){
        return ResponseEntity.ok(accountService.getAccountByCustomerTc(tckn));
    }

    @DeleteMapping("/{account_id}")
    public ResponseEntity<String> deleteAccountById(@PathVariable("account_id") Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.ok("Hesap Silme İşlemi Başarıyla Tamamlandı");
    }
}

