package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.PaymentTypeDTO;
import com.challenge.service.PaymentTypeService;
import com.challenge.util.ChallengeUtil;

@RestController
@RequestMapping("/payment-type")
public class PaymentTypeController {
	
	@Autowired
	PaymentTypeService paymentTypeService;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<PaymentTypeDTO>> findAll() {
		
		return ChallengeUtil.handleResponseList(paymentTypeService.findAll());
		
	}
}
