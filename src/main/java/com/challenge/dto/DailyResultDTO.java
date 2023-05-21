package com.challenge.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DailyResultDTO implements Serializable {
	
	private static final long serialVersionUID = -498919244777413075L;

	private LocalDate transactionDate;
	
	private Double totalCredit;
	private Double totalDebit;
	private Double total;
	
    public DailyResultDTO(LocalDate transactionDate, Double totalCredit, Double totalDebit) {
        this.transactionDate = transactionDate;
    	this.totalCredit = totalCredit;
    	this.totalDebit = totalDebit;
    	this.total = totalCredit - totalDebit;    	
    }

}
