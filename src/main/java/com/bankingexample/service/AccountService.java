package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.model.Account;

import java.util.Optional;

public interface AccountService {
    public Account findById(Long id);
    public Optional<Account> findOptionalById(Long id);
    public Account save(AccountDTO accountDTO) throws BusinessException;
}
