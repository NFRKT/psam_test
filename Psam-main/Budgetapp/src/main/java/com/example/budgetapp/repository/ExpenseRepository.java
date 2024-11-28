package com.example.budgetapp.repository;

import com.example.budgetapp.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Zapytanie do pobrania wydatków według daty
    List<Expense> findByDate(LocalDate date);

    // Zapytanie do pobrania wydatków według kategorii
    List<Expense> findByCategory(String category);

    // Zapytanie do pobrania wydatków w danym przedziale dat
    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

