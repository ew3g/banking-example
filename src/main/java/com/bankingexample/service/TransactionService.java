package com.bankingexample.service;

import com.bankingexample.dto.TransactionDTO;
import com.bankingexample.error.BusinessException;
import com.bankingexample.model.Transaction;

public interface TransactionService {

    public Transaction save(TransactionDTO transactionDTO) throws BusinessException;
}
