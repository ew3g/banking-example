package com.bankingexample.model;

import com.bankingexample.dto.AccountDTO;

public class AccountStubs {

    public static AccountDTO get() {
        return AccountDTO.builder()
                .id(1L)
                .documentNumber("12345678900")
                .build();
    }
}
