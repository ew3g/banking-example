package com.bankingexample.service;

import com.bankingexample.dto.TransactionDTO;
import com.bankingexample.model.Transaction;
import com.bankingexample.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository transactionRepository;
    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    @Override
    public Transaction save(TransactionDTO transaction) {
        return transactionRepository.save(transaction.toTransaction());
    }
}
