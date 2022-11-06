package com.bankingexample.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @SerializedName("transaction_id")
    @Id
    @GeneratedValue
    @Column(name = "transaction_id")
    private Long transactionId;

    @SerializedName("account_id")
    @Column(name = "account_id")
    private Long accountId;

    @SerializedName("operation_type_id")
    @Column(name = "operation_type_id")
    private Integer operationTypeId;

    private BigDecimal amount;

    @SerializedName("event_date")
    @CreationTimestamp
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id", insertable = false, updatable = false)
    private OperationType operationType;
}
