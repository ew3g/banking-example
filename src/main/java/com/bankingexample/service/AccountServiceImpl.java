package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.model.Account;
import com.bankingexample.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Account save(AccountDTO accountDTO) throws BusinessException {

        if(accountRepository.findFirstByDocumentNumber(accountDTO.getDocumentNumber()).isPresent())
            throw BusinessException.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .internalMessage("Já existe")
                    .message("Já existe")
                    .build();

        return accountRepository.save(accountDTO.toAccount());
    }
}
