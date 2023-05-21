package com.challenge.service;

import java.util.List;

import com.challenge.dto.TransactionTypeDTO;

public interface TransactionTypeService {
	List<TransactionTypeDTO> findAll();
}
