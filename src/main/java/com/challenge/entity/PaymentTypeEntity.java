package com.challenge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(name = "payment_type")
@Data
@Entity
public class PaymentTypeEntity {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(columnDefinition="BIGINT")
    private Integer id;

    private String description;

}