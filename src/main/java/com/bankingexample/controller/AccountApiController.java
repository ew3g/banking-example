package com.bankingexample.controller;

import com.bankingexample.model.Account;
import com.bankingexample.model.Transaction;
import com.bankingexample.repository.OperationTypeRepository;
import com.bankingexample.repository.TransactionRepository;
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
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class AccountApiController implements AccountApi {

    private static final Logger log = LoggerFactory.getLogger(AccountApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final OperationTypeRepository operationTypeRepository;

    private final TransactionRepository transactionRepository;

    @Autowired
    public AccountApiController(ObjectMapper objectMapper, HttpServletRequest request, OperationTypeRepository operationTypeRepository, TransactionRepository transactionRepository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.operationTypeRepository = operationTypeRepository;
        this.transactionRepository = transactionRepository;
    }

    public ResponseEntity<Account> findAccountByID(@Parameter(in = ParameterIn.PATH, description = "Account unique id", required=true, schema=@Schema()) @PathVariable("accountId") BigDecimal accountId) {
        String accept = request.getHeader("Accept");

        System.out.println(transactionRepository.findAll().get(0));
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Account>(objectMapper.readValue("{\n  \"account_id\" : 1,\n  \"document_number\" : \"12345678900\"\n}", Account.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Account>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Account>(HttpStatus.NOT_IMPLEMENTED);
    }

    @Override
    public ResponseEntity<Account> createAccount(Account body) {

        List<Transaction> list = transactionRepository.findAll();
        for(Transaction t : list) {
            System.out.println(t.getAccount().getDocumentNumber());
            System.out.println(t.getAmount());
            System.out.println(t.getOperationType().getDescription());
        }

        return null;
    }

}
