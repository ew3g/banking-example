package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.model.Account;
import com.bankingexample.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public Account save(AccountDTO accountDTO) {
        return accountRepository.save(accountDTO.toAccount());
    }
}
