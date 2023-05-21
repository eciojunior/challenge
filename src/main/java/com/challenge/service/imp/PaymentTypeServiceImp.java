package com.challenge.service.imp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.dto.PaymentTypeDTO;
import com.challenge.repository.PaymentTypeRepository;
import com.challenge.service.PaymentTypeService;

@Service
public class PaymentTypeServiceImp  implements PaymentTypeService{

	@Autowired
	PaymentTypeRepository paymentTypeRepository;
	
	@Autowired
	ModelMapper mapper;

	@Override
	public List<PaymentTypeDTO> findAll() {
		return paymentTypeRepository
				.findAll()
				.stream()
				.map(t -> mapper.map(t, PaymentTypeDTO.class))
				.collect(Collectors.toList());
	}

}
