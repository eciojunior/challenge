package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.PaymentTypeEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PaymentTypeRepository extends JpaRepository<PaymentTypeEntity, Integer>{

}
