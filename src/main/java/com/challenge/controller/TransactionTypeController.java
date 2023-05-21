package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.TransactionTypeDTO;
import com.challenge.service.TransactionTypeService;
import com.challenge.util.ChallengeUtil;

@RestController
@RequestMapping("/transaction-type")
public class TransactionTypeController {
	
	@Autowired
	TransactionTypeService transactionTypeService;

	@GetMapping("/all")
	public ResponseEntity<List<TransactionTypeDTO>> findAll() {
		
		return ChallengeUtil.handleResponseList(transactionTypeService.findAll());
		
	}
	
}
