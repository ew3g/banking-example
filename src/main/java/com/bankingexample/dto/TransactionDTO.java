package com.bankingexample.dto;

import com.bankingexample.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
public class TransactionDTO implements Serializable {
    private static final long serialVersionUID = -3365914641657631690L;

    @JsonProperty("transaction_id")
    private Long transactionId;
    @JsonProperty("account_id")
    @NotNull
    private Long accountId;
    @JsonProperty("operation_type_id")
    @NotNull
    private Long operationTypeId;
    @JsonProperty("amount")
    @NotNull
    @Min(0)
    private BigDecimal amount;
    @JsonIgnore
    private LocalDateTime eventDate;

    public Transaction toTransaction() {
        return Transaction.builder()
                .transactionId(this.transactionId)
                .accountId(this.accountId)
                .operationTypeId(this.operationTypeId)
                .amount(this.amount)
                .eventDate(this.eventDate)
                .build();
    }
}
