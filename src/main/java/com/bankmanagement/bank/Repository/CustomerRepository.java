package com.bankmanagement.bank.Repository;

import com.bankmanagement.bank.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByTckn(String tc);
    void deleteByTckn(String tc);

}
