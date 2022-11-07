package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.model.Account;
import org.springframework.stereotype.Service;

public interface AccountService {
    public Account findAccountById(Long id);
    public Account save(AccountDTO accountDTO);
}
