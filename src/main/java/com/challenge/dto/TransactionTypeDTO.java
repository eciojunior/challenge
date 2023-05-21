package com.challenge.dto;


import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionTypeDTO implements Serializable {

	private static final long serialVersionUID = -5567981499212815813L;
	
	private String acronym;
    private String description;

}