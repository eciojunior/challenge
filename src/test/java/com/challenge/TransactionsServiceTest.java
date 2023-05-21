package com.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

import com.challenge.dto.DailyResultDTO;
import com.challenge.dto.PaymentTypeDTO;
import com.challenge.dto.TransactionTypeDTO;
import com.challenge.dto.TransactionsDTO;
import com.challenge.entity.PaymentTypeEntity;
import com.challenge.entity.TransactionTypeEntity;
import com.challenge.entity.TransactionsEntity;
import com.challenge.exception.ParameterValidationException;
import com.challenge.repository.PaymentTypeRepository;
import com.challenge.repository.TransactionTypeRepository;
import com.challenge.repository.TransactionsRepository;
import com.challenge.service.imp.TransactionsServiceImp;

public class TransactionsServiceTest extends ChallengeApplicationTests {
	
    @InjectMocks
    TransactionsServiceImp service;
    
    @Mock
	ModelMapper mapper;
	
	@Mock 
	TransactionsRepository repository;
	
	@Mock
	TransactionTypeRepository transactionTypeRepository;
	
	@Mock
	PaymentTypeRepository paymentTypeRepository;
    
	@Test
	public void findAllByDate() {
		when(repository.findByTransactionDateBetween(any(LocalDate.class), any(LocalDate.class))).thenReturn(new ArrayList<>());
        assertTrue(service.findTransactionsByDate("2023-01-01", "2023-01-31").isEmpty());
	}
	
	@Test
	public void dailyResult() {
		List<DailyResultDTO> list = new ArrayList<>();
		list.add(createDailyResultDTO());
		when(repository.dailyResult(any(LocalDate.class), any(LocalDate.class))).thenReturn(list);
		assertEquals(service.dailyResult("2023-01-01", "2023-01-31").get(0).getTotal(), 4d);
	}
	
	@Test
	public void registrySuccess() throws ParameterValidationException {
		when(transactionTypeRepository.findById(anyString())).thenReturn(Optional.ofNullable(new TransactionTypeEntity()));
		when(paymentTypeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(new PaymentTypeEntity()));
		when(repository.save(any(TransactionsEntity.class))).thenReturn(null);
		when(mapper.map(any(TransactionsDTO.class), any())).thenReturn(new TransactionsEntity());
		service.registry(createTransactionsDTO());
		assertTrue(true);
	}
	
	@Test
	public void registryFail() throws ParameterValidationException {
		when(transactionTypeRepository.findById(anyString())).thenReturn(Optional.ofNullable(null));
		when(paymentTypeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(null));
		assertThrows(ParameterValidationException.class, () -> service.registry(createTransactionsDTO()));
	}
	
	private TransactionsDTO createTransactionsDTO() {
		PaymentTypeDTO ptDto = new PaymentTypeDTO();
		ptDto.setId(1);
		TransactionTypeDTO ttDto = new TransactionTypeDTO();
		ttDto.setAcronym("C");
		
		TransactionsDTO dto = new TransactionsDTO();
		dto.setAmount(10f);
		dto.setCreatedAt(LocalDateTime.now());
		dto.setDescription("teste unitario");
		dto.setTransactionDate(LocalDate.now());
		dto.setPaymentType(ptDto);
		dto.setTransactionType(ttDto);
		
		return dto;
	}
	
    private DailyResultDTO createDailyResultDTO() {
    	DailyResultDTO dto = new DailyResultDTO(LocalDate.parse("2023-01-01"), 10d, 6d);
    	return dto;
    }
    
}
