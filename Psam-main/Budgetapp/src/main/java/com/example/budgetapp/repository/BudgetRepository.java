package com.example.budgetapp.repository;

import com.example.budgetapp.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByCategory(String category);
    List<Budget> findByPeriod(String period);
    Budget findByCategoryAndPeriod(String category, String period);
}