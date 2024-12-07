package com.bankmanagement.bank.repository;

import com.bankmanagement.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Set<Account> findByCustomerId(Long id);

    @Query("UPDATE Account a SET a.balance = :balance WHERE a.id = :accountId")
    void updateBalance(@Param("accountId") Long accountId, @Param("balance") BigDecimal balance);
}
