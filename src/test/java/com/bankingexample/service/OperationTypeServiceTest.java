package com.bankingexample.service;

import com.bankingexample.model.OperationType;
import com.bankingexample.model.OperationTypeStubs;
import com.bankingexample.repository.OperationTypeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class OperationTypeServiceTest {

    @Mock
    private OperationTypeRepository operationTypeRepository;

    @InjectMocks
    private OperationTypeServiceImpl operationTypeService;

    @Test
    @DisplayName("OperationTypeService - Should create a new operation type")
    public void shouldCreateNewOperationType() {
        OperationType operationType = OperationTypeStubs.get();

        Mockito.when(operationTypeRepository.save(Mockito.any(OperationType.class))).thenReturn(operationType);

        OperationType result = operationTypeService.save(operationType);

        Mockito.verify(operationTypeRepository, Mockito.times(1))
                .save(Mockito.any(OperationType.class));
        Assertions.assertEquals(operationType, result);
    }
}
