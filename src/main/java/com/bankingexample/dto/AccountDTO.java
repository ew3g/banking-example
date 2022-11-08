package com.bankingexample.dto;

import com.bankingexample.model.Account;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Builder
@Data
public class AccountDTO implements Serializable {
    private static final long serialVersionUID = 7490064969990183564L;

    @JsonProperty("account_id")
    private Long id;

    @JsonProperty("document_number")
    @NotNull
    @NotBlank
    @Size(min = 10, max = 14)
    @Pattern(regexp = "^[\\d]{10,14}$", message = "numbers only, 10-14 characters long")
    private String documentNumber;

    public Account toAccount() {
        return Account.builder()
                .id(this.id)
                .documentNumber(this.documentNumber)
                .build();
    }
}
