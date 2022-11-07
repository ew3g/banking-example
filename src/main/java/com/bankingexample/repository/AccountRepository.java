package com.bankingexample.repository;

import com.bankingexample.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Optional<Account> findFirstByDocumentNumber(String documentNumber);
}
