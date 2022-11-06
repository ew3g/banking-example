package com.bankingexample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "operation_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationType {

    @Id
    @GeneratedValue
    @Column(name = "operation_type_id")
    private Long id;

    @Column(unique = true)
    private String description;
}
