package com.challenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.entity.TransactionTypeEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TransactionTypeRepository extends JpaRepository<TransactionTypeEntity, String> {

}
