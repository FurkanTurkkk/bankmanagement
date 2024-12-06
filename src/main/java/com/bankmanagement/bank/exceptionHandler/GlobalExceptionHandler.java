package com.bankmanagement.bank.exceptionHandler;

import com.bankmanagement.bank.exception.AccountAlreadyExistException;
import com.bankmanagement.bank.exception.AccountNotFoundException;
import com.bankmanagement.bank.exception.CustomerNotFoundException;
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