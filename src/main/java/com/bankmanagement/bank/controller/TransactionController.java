package com.bankmanagement.bank.controller;

import com.bankmanagement.bank.dto.TransactionDto;
import com.bankmanagement.bank.model.Account;
import com.bankmanagement.bank.model.Transaction;
import com.bankmanagement.bank.service.TransactionService;
import com.bankmanagement.bank.userRequest.CreateForTransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService, AccountController accountController) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody CreateForTransaction request){
        Account account=transactionService.findAccountByAccountId(request.getAccount_id());
        Transaction transaction=new Transaction(
                request.getTransDate(),
                request.getTransactionType(),
                request.getAmount(),
                account
        );

        return ResponseEntity.ok(transactionService.addTransaction(transaction,account));
    }
}
