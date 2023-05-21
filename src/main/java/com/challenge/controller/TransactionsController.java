package com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.dto.DailyResultDTO;
import com.challenge.dto.TransactionsDTO;
import com.challenge.service.TransactionsService;
import com.challenge.util.ChallengeUtil;

@RestController
@RequestMapping("/transactions")
public class TransactionsController {
	
	@Autowired
	TransactionsService transactionsService;

	@GetMapping("/find")
	@ResponseBody
	public ResponseEntity<List<TransactionsDTO>> findByDate(
			@RequestParam(required = true, value="from") String to, 
			@RequestParam(required = true, value="to") String from) {
		
		List<TransactionsDTO> response = transactionsService.findTransactionsByDate(to, from);
		return ChallengeUtil.handleResponseList(response);
		
	}
	
	@GetMapping("/result/daily")
	@ResponseBody
	public ResponseEntity<List<DailyResultDTO>> dailyResult(
			@RequestParam(required = true, value="from") String to, 
			@RequestParam(required = true, value="to") String from) {
		
		List<DailyResultDTO> response = transactionsService.dailyResult(to, from);
		return ChallengeUtil.handleResponseList(response);
		
	}
	
	@PostMapping("/registry")
	@ResponseBody
	public ResponseEntity<?> registry(@RequestBody TransactionsDTO transaction  ) {
		try {
			transactionsService.registry(transaction);
			return ResponseEntity.status(HttpStatus.CREATED).body("Registro criado com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
			ResponseStatus responseStatus = AnnotatedElementUtils.getMergedAnnotation(e.getClass(), ResponseStatus.class);
		    HttpStatus status = responseStatus != null ? responseStatus.value() : HttpStatus.BAD_REQUEST ;
			return ResponseEntity.status(status).body(e.getLocalizedMessage());
		}
	}

}
