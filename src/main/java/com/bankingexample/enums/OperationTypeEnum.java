package com.bankingexample.enums;

public enum OperationTypeEnum {
    PURCHASE(1),
    INSTALLMENT_PURCHASE(2),
    WITHDRAWAL(3),
    PAYMENT(4);

    private Integer code;

    public Integer getOperationTypeCode() {
        return code;
    }

    private OperationTypeEnum(Integer code) {
        this.code = code;
    }
}
