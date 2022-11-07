package com.bankingexample.dto;

import com.bankingexample.model.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO implements Serializable {

    private static final long serialVersionUID = 7490064969990183564L;

    @JsonProperty("account_id")
    private Long id;

    @JsonProperty("account_number")
    private String documentNumber;

    public Account toAccount() {
        return Account.builder()
                .id(this.id)
                .documentNumber(this.documentNumber)
                .build();
    }
}
