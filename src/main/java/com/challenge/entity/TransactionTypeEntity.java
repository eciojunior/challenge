package com.challenge.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transaction_type")
@Data
public class TransactionTypeEntity {

    @Id
    private String acronym;
    private String description;

}