package com.bankmanagement.bank.ExceptionHandler;

import com.bankmanagement.bank.Exception.AccountAlreadyExistException;
import com.bankmanagement.bank.Exception.AccountNotFoundException;
import com.bankmanagement.bank.Exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountAlreadyExistException.class)
    public ResponseEntity<String> handleAccountAlreadyExistException(AccountAlreadyExistException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
    }
}
