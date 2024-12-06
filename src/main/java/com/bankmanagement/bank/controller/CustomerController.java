package com.bankmanagement.bank.controller;

import com.bankmanagement.bank.dto.CustomerDto;
import com.bankmanagement.bank.model.Customer;
import com.bankmanagement.bank.service.CustomerService;
import com.bankmanagement.bank.userRequest.CreateForCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CreateForCustomer request){
        Customer customer = new Customer(request.getUserName(),request.getPassword(),request.getFirstName(),
                request.getLastName(),request.geteMailAddress(),request.getTCkn());
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @GetMapping("/{customer_id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("customer_id") Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @GetMapping
    public ResponseEntity<Set<CustomerDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @DeleteMapping("/tc/{tckn}")
    public ResponseEntity<String> deleteCustomerByTckn(@PathVariable("tckn") String tckn){
        customerService.deleteCustomerByTckn(tckn);
        return ResponseEntity.ok("Müşteri ve hesapları başarıyla silindi.");
    }

    @GetMapping("/more-than-accounts/{accountCount}")
    public ResponseEntity<List<CustomerDto>> getCustomersWithMoreThanAccounts(
            @PathVariable("accountCount") int accountCount) {
        List<CustomerDto> customers = customerService.getCustomersWithMoreThanAccounts(accountCount);
        return ResponseEntity.ok(customers);

    }
}
