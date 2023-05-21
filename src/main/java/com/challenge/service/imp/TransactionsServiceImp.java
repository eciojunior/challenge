package com.challenge.service.imp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.DailyResultDTO;
import com.challenge.dto.TransactionsDTO;
import com.challenge.entity.PaymentTypeEntity;
import com.challenge.entity.TransactionTypeEntity;
import com.challenge.entity.TransactionsEntity;
import com.challenge.exception.ParameterValidationException;
import com.challenge.repository.PaymentTypeRepository;
import com.challenge.repository.TransactionTypeRepository;
import com.challenge.repository.TransactionsRepository;
import com.challenge.service.TransactionsService;

@Service
public class TransactionsServiceImp implements TransactionsService {
	
	@Autowired 
	TransactionsRepository transactionsRepository;
	
	@Autowired
	TransactionTypeRepository transactionTypeRepository;
	
	@Autowired
	PaymentTypeRepository paymentTypeRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<TransactionsDTO> findTransactionsByDate (String to, String from) {
		return transactionsRepository
					.findByTransactionDateBetween(LocalDate.parse(to), LocalDate.parse(from))
					.stream()
					.map(t -> mapper.map(t, TransactionsDTO.class))
					.collect(Collectors.toList());
	}
	
	@Override
	public void registry (TransactionsDTO transaction) throws ParameterValidationException {
		Optional<TransactionTypeEntity> ttEntity = transactionTypeRepository.findById(transaction.getTransactionType().getAcronym().toUpperCase());
		Optional<PaymentTypeEntity> ptEntity = paymentTypeRepository.findById(transaction.getPaymentType().getId());

		validateEnititys(ttEntity, ptEntity);
		
		TransactionsEntity entity = createTransactionEntityToSave(transaction, ttEntity, ptEntity);
		transactionsRepository.save(entity);
	}
	
	@Override
	public List<DailyResultDTO> dailyResult (String to, String from) {
		return transactionsRepository.dailyResult(LocalDate.parse(to), LocalDate.parse(from));	
	}
	
	private TransactionsEntity createTransactionEntityToSave(TransactionsDTO transaction,
			Optional<TransactionTypeEntity> ttEntity, Optional<PaymentTypeEntity> ptEntity) {
		TransactionsEntity entity = mapper.map(transaction, TransactionsEntity.class);
		entity.setTransactionType(ttEntity.get());
		entity.setPaymentType(ptEntity.get());
		return entity;
	}

	private void validateEnititys(Optional<TransactionTypeEntity> ttEntity, Optional<PaymentTypeEntity> ptEntity) throws ParameterValidationException {
		if (ttEntity.isEmpty()) {
			throw new ParameterValidationException("Tipo de transação inválido");
		}
		if (ptEntity.isEmpty()) {
			throw new ParameterValidationException("Tipo de pagamento inválido");
		}
	}
	
}
