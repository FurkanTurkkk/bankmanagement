package com.bankmanagement.bank.repository;

import com.bankmanagement.bank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByTckn(String tc);
    void deleteByTckn(String tc);

    @Query("SELECT c FROM Customer c JOIN c.accounts a GROUP BY c HAVING COUNT(a) > :accountCount")
    List<Customer> findCustomerWithMoreThanAccounts(@Param("accountCount") int accountCount);


}
