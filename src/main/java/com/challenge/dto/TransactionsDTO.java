package com.challenge.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionsDTO implements Serializable {

	private static final long serialVersionUID = -4188213064846643872L;
	
	private Long id;
    private LocalDate transactionDate;
    private Float amount;
    private LocalDateTime createdAt;
    private String description;
    private PaymentTypeDTO paymentType;
    private TransactionTypeDTO transactionType;

}