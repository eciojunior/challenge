package com.challenge.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.TransactionTypeDTO;
import com.challenge.repository.TransactionTypeRepository;
import com.challenge.service.TransactionTypeService;

@Service
public class TransactionTypeServiceImp implements TransactionTypeService{

	@Autowired
	TransactionTypeRepository transactionTypeRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<TransactionTypeDTO> findAll() {
		return transactionTypeRepository
				.findAll()
				.stream()
				.map(t -> mapper.map(t, TransactionTypeDTO.class))
				.collect(Collectors.toList());
	}

}
