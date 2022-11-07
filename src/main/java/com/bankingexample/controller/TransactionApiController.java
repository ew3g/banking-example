package com.bankingexample.controller;

import com.bankingexample.dto.TransactionDTO;
import com.bankingexample.model.Transaction;
import com.bankingexample.repository.TransactionRepository;
import com.bankingexample.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class TransactionApiController implements TransactionApi{

    private static final Logger log = LoggerFactory.getLogger(TransactionApiController.class);

    private TransactionService transactionService;

    @Autowired
    public TransactionApiController(TransactionService transactionService) {
       this.transactionService = transactionService;
    }

    public ResponseEntity<TransactionDTO> createTransaction(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody TransactionDTO transactionDTO) {
        return new ResponseEntity<>(transactionService.save(transactionDTO).toTransactionDTO(), HttpStatus.CREATED);
    }
}
