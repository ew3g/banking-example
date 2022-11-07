package com.bankingexample.controller;

import com.bankingexample.dto.AccountDTO;
import com.bankingexample.model.Account;
import com.bankingexample.model.Transaction;
import com.bankingexample.repository.OperationTypeRepository;
import com.bankingexample.repository.TransactionRepository;
import com.bankingexample.service.AccountService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountApiController implements AccountApi {

    private static final Logger log = LoggerFactory.getLogger(AccountApiController.class);

    private final AccountService accountService;

    @Autowired
    public AccountApiController(AccountService accountService) {
        this.accountService = accountService;
    }

    public ResponseEntity<AccountDTO> findAccountByID(@Parameter(in = ParameterIn.PATH, description = "Account unique id", required=true, schema=@Schema()) @PathVariable("accountId") Long accountId) {
        return new ResponseEntity<>(accountService.findAccountById(accountId).toAccountDTO(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AccountDTO> createAccount(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(accountService.save(accountDTO).toAccountDTO(), HttpStatus.CREATED);
    }
}
