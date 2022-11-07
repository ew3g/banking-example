package com.bankingexample.model;

public class OperationTypeStubs {

    public static OperationType get() {
        return OperationType.builder()
                .id(1L)
                .internalCode(1)
                .description("PURCHASE")
                .build();
    }
}
