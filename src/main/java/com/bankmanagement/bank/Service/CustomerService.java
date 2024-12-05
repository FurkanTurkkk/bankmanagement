package com.bankmanagement.bank.Service;

import com.bankmanagement.bank.Converter.CustomerDtoConverter;
import com.bankmanagement.bank.Dto.CustomerDto;
import com.bankmanagement.bank.Exception.CustomerNotFoundException;
import com.bankmanagement.bank.Model.Customer;
import com.bankmanagement.bank.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    public Optional<Customer> findCustomerByTc(String tc){
        return customerRepository.findByTCkn(tc);
    }

    public CustomerDto addCustomer(Customer customer){
        Optional<Customer> customer1=findCustomerByTc(customer.getTCkn());
        if(customer1.isPresent()){
            throw new IllegalStateException("Müşteri zaten mevcut"+" "
                    +customer.getFirstName()+" "+customer.getAccounts());
        }else {
            Customer savedCustomer=customerRepository.save(customer);
            return converter.convertToCustomerDto(savedCustomer);
        }

    }

    public Customer findCustomerById(Long id){
        return customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException("Customer Not Found By Id : "+id));
    }

    public CustomerDto getCustomerById(Long id){
        return converter.convertToCustomerDto(findCustomerById(id));
    }

    public Set<CustomerDto> getAllCustomer(){
        Set<Customer> customers= new HashSet<>(customerRepository.findAll());
        return customers.stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toSet());
    }

}
