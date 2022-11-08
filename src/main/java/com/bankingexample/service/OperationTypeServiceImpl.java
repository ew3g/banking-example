package com.bankingexample.service;

import com.bankingexample.model.OperationType;
import com.bankingexample.repository.OperationTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OperationTypeServiceImpl implements OperationTypeService{

    private OperationTypeRepository operationTypeRepository;

    @Autowired
    public OperationTypeServiceImpl(OperationTypeRepository operationTypeRepository) {
        this.operationTypeRepository = operationTypeRepository;
    }

    @Override
    public OperationType save(OperationType operationType) {
        return operationTypeRepository.save(operationType);
    }

    @Override
    public Optional<OperationType> findById(Long id) {
        return operationTypeRepository.findById(id);
    }
}
