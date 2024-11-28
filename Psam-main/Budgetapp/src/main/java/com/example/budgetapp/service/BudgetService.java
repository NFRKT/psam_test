package com.example.budgetapp.service;

import com.example.budgetapp.model.Budget;
import com.example.budgetapp.repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }


    public Budget addBudget(Budget budget) {
        return budgetRepository.save(budget);
    }


    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }


    public Budget getBudgetById(Long id) {
        return budgetRepository.findById(id).orElse(null);
    }


    public List<Budget> getBudgetsByCategory(String category) {
        return budgetRepository.findByCategory(category);
    }


    public Budget getBudgetByCategoryAndPeriod(String category, String period) {
        return budgetRepository.findByCategoryAndPeriod(category, period);
    }


    public Budget updateBudget(Long id, Budget budget) {
        if (budgetRepository.existsById(id)) {
            budget.setId(id);
            return budgetRepository.save(budget);
        }
        return null;
    }


    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}