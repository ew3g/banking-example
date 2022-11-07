package com.bankingexample.dto;

import com.bankingexample.model.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO implements Serializable {

    private static final long serialVersionUID = -3365914641657631690L;

    @JsonProperty("transaction_id")
    private Long transactionId;
    @JsonProperty("account_id")
    private Long accountId;
    @JsonProperty("operation_type_id")
    private Long operationTypeId;
    @JsonProperty("amount")
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