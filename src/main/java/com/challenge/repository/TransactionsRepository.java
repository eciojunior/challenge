package com.challenge.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.challenge.dto.DailyResultDTO;
import com.challenge.entity.TransactionsEntity;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface TransactionsRepository extends JpaRepository<TransactionsEntity, Long> {
	
	List<TransactionsEntity> findByTransactionDateBetween(LocalDate to, LocalDate from);
	
	@Query("SELECT new com.challenge.dto.DailyResultDTO(t.transactionDate, "
	        + "SUM(CASE WHEN t.transactionType.acronym = 'C' THEN t.amount ELSE 0 END), "
	        + "SUM(CASE WHEN t.transactionType.acronym = 'D' THEN t.amount ELSE 0 END)) "
	        + "FROM TransactionsEntity AS t "
	        + "WHERE t.transactionDate BETWEEN :from AND :to "
	        + "GROUP BY t.transactionDate")
	List<DailyResultDTO> dailyResult(@Param("from") LocalDate from, @Param("to") LocalDate to);

}
