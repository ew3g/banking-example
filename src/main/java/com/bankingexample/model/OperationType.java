package com.bankingexample.model;

import enums.OperationTypeBehaviorEnum;
import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "operation_type")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "operation_type_id")
    private Long id;

    @Column(name = "internal_code")
    private Integer internalCode;

    @Column(unique = true)
    private String description;

    @Enumerated(EnumType.STRING)
    private OperationTypeBehaviorEnum behavior;
}
