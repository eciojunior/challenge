package com.challenge.service;

import java.util.List;

import com.challenge.dto.DailyResultDTO;
import com.challenge.dto.TransactionsDTO;
import com.challenge.exception.ParameterValidationException;

public interface TransactionsService {
	
	List<TransactionsDTO> findTransactionsByDate (String to, String from);
	List<DailyResultDTO> dailyResult (String to, String from);
	void registry (TransactionsDTO transaction) throws ParameterValidationException;
	
}
