package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.model.Account;

public interface AccountService {
    public Account findAccountById(Long id);
    public Account save(AccountDTO accountDTO) throws BusinessException;
}
