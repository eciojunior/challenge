package com.challenge.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentTypeDTO implements Serializable {

	private static final long serialVersionUID = 7502630955504900548L;
	
	private Integer id;
    private String description;

}