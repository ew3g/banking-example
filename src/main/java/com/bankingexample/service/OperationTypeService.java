package com.bankingexample.service;

import com.bankingexample.model.OperationType;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface OperationTypeService {

    public OperationType save(OperationType operationType);
    public Optional<OperationType> findById(Long id);
}
