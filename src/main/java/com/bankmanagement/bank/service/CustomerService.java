package com.bankmanagement.bank.service;

import com.bankmanagement.bank.converter.CustomerDtoConverter;
import com.bankmanagement.bank.dto.CustomerDto;
import com.bankmanagement.bank.exception.CustomerNotFoundException;
import com.bankmanagement.bank.model.Customer;
import com.bankmanagement.bank.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    public Customer findCustomerByTc(String tc) {

        return customerRepository.findByTckn(tc).orElseThrow(
                () -> new CustomerNotFoundException("Bu TC kimlik numarasına ait müşteri bulunamadı." + tc));

    }

    public CustomerDto addCustomer(Customer customer) {
        Customer registeredCustomer=customerRepository.findByTckn(customer.gettckn()).orElse(new Customer());
        if (Objects.equals(registeredCustomer.gettckn(), customer.gettckn())) {
            throw new IllegalStateException("Müşteri zaten mevcut" + " "
                    + customer.getFirstName() + " " + customer.getAccounts());
        } else {
            Customer savedCustomer = customerRepository.save(customer);
            return converter.convertToCustomerDto(savedCustomer);
        }

    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer Not Found By Id : " + id));
    }

    @Transactional
    public CustomerDto getCustomerById(Long id) {
        return converter.convertToCustomerDto(findCustomerById(id));
    }

    @Transactional
    public Set<CustomerDto> getAllCustomer() {
        Set<Customer> customers = new HashSet<>(customerRepository.findAll());
        return customers.stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toSet());
    }

    @Transactional
    public void deleteCustomerByTckn(String tckn) {
        Customer customer = findCustomerByTc(tckn);
        customer.getAccounts().clear();
        customerRepository.delete(customer);
    }

    @Transactional
    public List<CustomerDto> getCustomersWithMoreThanAccounts(int accountCount) {
        List<Customer> customers = customerRepository.findCustomerWithMoreThanAccounts(accountCount);
        return customers.stream()
                .map(converter::convertToCustomerDto)
                .collect(Collectors.toList());
    }

}
