package com.example.budgetapp.service;

import com.example.budgetapp.model.Expense;
import com.example.budgetapp.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Dodawanie nowego wydatku
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    // Pobieranie wszystkich wydatków
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Pobieranie wydatków po ID
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.orElse(null);
    }

    // Pobieranie wydatków po dacie
    public List<Expense> getExpensesByDate(LocalDate date) {
        return expenseRepository.findByDate(date);
    }

    // Pobieranie wydatków po kategorii
    public List<Expense> getExpensesByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

    // Pobieranie wydatków w danym przedziale dat
    public List<Expense> getExpensesBetweenDates(LocalDate startDate, LocalDate endDate) {
        return expenseRepository.findByDateBetween(startDate, endDate);
    }

    // Usuwanie wydatku
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Aktualizowanie wydatku
    public Expense updateExpense(Long id, Expense expense) {
        if (expenseRepository.existsById(id)) {
            expense.setId(id);
            return expenseRepository.save(expense);
        }
        return null;
    }
}