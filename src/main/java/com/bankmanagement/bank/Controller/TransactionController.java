package com.bankmanagement.bank.Controller;

import com.bankmanagement.bank.Dto.TransactionDto;
import com.bankmanagement.bank.Model.Transaction;
import com.bankmanagement.bank.Service.TransactionService;
import com.bankmanagement.bank.UserRequest.CreateForTransaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDto> addTransaction(@RequestBody CreateForTransaction request){
        Transaction transaction=new Transaction(
                request.getTransDate(),
                request.getTransactionType(),
                request.getAmount(),
                request.getAccount()
        );
        return ResponseEntity.ok(transactionService.addTransaction(transaction));
    }
}
