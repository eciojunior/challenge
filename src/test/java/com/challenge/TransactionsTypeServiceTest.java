package com.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.repository.TransactionTypeRepository;
import com.challenge.service.imp.TransactionTypeServiceImp;

public class TransactionsTypeServiceTest extends ChallengeApplicationTests {
	
	@Mock
	TransactionTypeRepository transactionTypeRepository;
	
	@Autowired
	ModelMapper mapper;
	
    @InjectMocks
    TransactionTypeServiceImp transactionTypeService;
	
	@Test
	public void findAll() {
		when(transactionTypeRepository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(transactionTypeService.findAll().isEmpty());
	}
}
