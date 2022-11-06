package com.bankingexample.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @SerializedName("account_id")
    @Id
    @GeneratedValue
    @Column(name = "account_id")
    private Long id;

    @SerializedName("document_number")
    @Column(length = 14, unique = true)
    private String documentNumber;
}
