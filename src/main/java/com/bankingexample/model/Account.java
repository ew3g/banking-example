package com.bankingexample.model;

import com.bankingexample.dto.AccountDTO;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @Column(length = 14, unique = true)
    private String documentNumber;

    public AccountDTO toAccountDTO() {
        return AccountDTO.builder()
                .id(this.id)
                .documentNumber(this.documentNumber)
                .build();
    }
}
