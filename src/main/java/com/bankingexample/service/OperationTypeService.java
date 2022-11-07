package com.bankingexample.service;

import com.bankingexample.model.OperationType;
import org.springframework.stereotype.Service;

public interface OperationTypeService {

    public OperationType save(OperationType operationType);
}
