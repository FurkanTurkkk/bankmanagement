package com.bankmanagement.bank.Controller;

import com.bankmanagement.bank.Dto.AccountDto;
import com.bankmanagement.bank.Dto.CustomerDto;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Service.CustomerService;
import com.bankmanagement.bank.UserRequest.CreateForCustomer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
