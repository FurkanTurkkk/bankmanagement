package com.bankmanagement.bank.repository;

import com.bankmanagement.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Set<Account> findByCustomerId(Long id);
}