package com.bankmanagement.bank.Controller;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Exception.CustomerNotFoundException;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Service.AccountService;
import com.bankmanagement.bank.UserRequest.CreateForAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService, CustomerController customerController) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody CreateForAccount request){
        Set<Account> accounts=accountService.findAccountByCustomerId(request.getCustomer_id());
        Set<Customer> customers=accounts.stream().map(Account::getCustomer).collect(Collectors.toSet());
        System.out.println("Customers: " + customers);
        Customer customer=customers.stream().filter(t->t.getId()==2)
                        .findFirst().orElseThrow(()->new CustomerNotFoundException("Customer Not Found"));

        return ResponseEntity.ok(accountService.addAccount(new Account(
                request.getBalance(),
                request.getCreationDate(),
                customer
        )));
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("account_id") Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
}

