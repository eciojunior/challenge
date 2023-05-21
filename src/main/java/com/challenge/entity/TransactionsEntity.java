package com.challenge.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "transactions")
public class TransactionsEntity {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_date", nullable = false)
    private LocalDate transactionDate;

    @Column(nullable = false, columnDefinition = "numeric(10,2)")
    private Float amount;
    
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_payment_type", nullable = false)
    private PaymentTypeEntity paymentType;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "acronym_transaction_type", nullable = false)
    private TransactionTypeEntity transactionType;

}