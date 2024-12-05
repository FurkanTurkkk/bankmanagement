package com.bankmanagement.bank.Controller;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Model.Account;
import com.bankmanagement.bank.Service.AccountService;
import com.bankmanagement.bank.UserRequest.CreateForAccount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody CreateForAccount request){
        Account account=new Account(request.getBalance(),
                request.getCreationDate(),
                request.getCustomer(),
                null);
        return ResponseEntity.ok(accountService.addAccount(account));
    }

    @GetMapping("/{account_id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable("account_id") Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }
}

