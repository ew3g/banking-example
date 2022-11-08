package com.bankingexample.service;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.error.ErrorConstants;
import com.bankingexample.model.Account;
import com.bankingexample.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account findById(Long id) {
        return accountRepository.getById(id);
    }

    @Override
    public Optional<Account> findOptionalById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(AccountDTO accountDTO) throws BusinessException {

        Optional<Account> existingAccountOpt = accountRepository
                .findFirstByDocumentNumber(accountDTO.getDocumentNumber());

        if(existingAccountOpt.isPresent()) {
            Account existingAccount = existingAccountOpt.get();
            throw BusinessException.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .internalMessage(String.format(ErrorConstants.ERROR_ALREADY_EXISTS, existingAccount))
                    .message(String.format(ErrorConstants.ERROR_ALREADY_EXISTS, existingAccount))
                    .build();
        }

        return accountRepository.save(accountDTO.toAccount());
    }
}
