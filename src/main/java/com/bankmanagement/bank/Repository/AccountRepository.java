package com.bankmanagement.bank.Repository;

import com.bankmanagement.bank.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Set<Account> findByCustomerId(Long id);
}
