package com.finance.bank.daos;


import com.finance.bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountDao extends JpaRepository<Account, String> {

    @Override
    List<Account> findAll();

    @Override
    Optional<Account> findById(String id);

    @Query("SELECT a FROM Account a WHERE a.user=:userfc")
    Optional<Account> findByUserFiscalCode(@Param("userfc") String fiscalCode);
}
