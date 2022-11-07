package com.bankingexample.model;

import com.bankingexample.dto.TransactionDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "operation_type_id")
    private Long operationTypeId;

    private BigDecimal amount;

    @CreationTimestamp
    private LocalDateTime eventDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", insertable = false, updatable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "operation_type_id", insertable = false, updatable = false)
    private OperationType operationType;

    public TransactionDTO toTransactionDTO() {
        return TransactionDTO.builder()
                .transactionId(this.transactionId)
                .accountId(this.accountId)
                .operationTypeId(this.operationTypeId)
                .amount(this.amount)
                .eventDate(this.eventDate)
                .build();
    }
}
