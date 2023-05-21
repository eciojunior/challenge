package com.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.challenge.repository.PaymentTypeRepository;
import com.challenge.service.imp.PaymentTypeServiceImp;

public class PaymentTypeServiceTest extends ChallengeApplicationTests {
	@Mock
	PaymentTypeRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
    @InjectMocks
    PaymentTypeServiceImp service;
	
	@Test
	public void findAll() {
		when(repository.findAll()).thenReturn(new ArrayList<>());
        assertTrue(service.findAll().isEmpty());
	}
}
