package com.bankingexample.service;

import com.bankingexample.dto.TransactionDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.error.ErrorConstants;
import com.bankingexample.model.Account;
import com.bankingexample.model.OperationType;
import com.bankingexample.model.Transaction;
import com.bankingexample.repository.TransactionRepository;
import enums.OperationTypeBehaviorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    private final OperationTypeService operationTypeService;
    private final AccountService accountService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository,
                                  OperationTypeService operationTypeService,
                                  AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.operationTypeService = operationTypeService;
        this.accountService = accountService;
    }

    @Override
    public Transaction save(TransactionDTO transaction) throws BusinessException {
        Optional<Account> accountOpt = accountService.findOptionalById(transaction.getAccountId());
        if (accountOpt.isEmpty()) {
            throw BusinessException.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(String.format(ErrorConstants.ERROR_NOT_EXISTS, transaction.getAccountId()))
                    .internalMessage(String.format(ErrorConstants.ERROR_NOT_EXISTS, transaction.getAccountId()))
                    .build();
        }

        Optional<OperationType> operationTypeOpt = operationTypeService.findById(transaction.getOperationTypeId());
        if (operationTypeOpt.isEmpty()) {
            throw BusinessException.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .message(String.format(ErrorConstants.ERROR_INVALID_OPERATION, transaction.getOperationTypeId()))
                    .internalMessage(String.format(ErrorConstants.ERROR_NOT_EXISTS, transaction.getOperationTypeId()))
                    .build();
        }

        // Invert the amount to negative
        OperationType operationType = operationTypeOpt.get();
        if (operationType.getBehavior().equals(OperationTypeBehaviorEnum.NEGATIVE)) {
            transaction.setAmount(transaction.getAmount().negate());
        }

        return transactionRepository.save(transaction.toTransaction());
    }
}
