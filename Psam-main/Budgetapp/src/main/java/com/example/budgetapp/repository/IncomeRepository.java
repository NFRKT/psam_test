package com.example.budgetapp.repository;

import com.example.budgetapp.model.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findBySource(String source);
    List<Income> findByDate(LocalDate date);
    List<Income> findByAmountGreaterThan(Double amount);
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}