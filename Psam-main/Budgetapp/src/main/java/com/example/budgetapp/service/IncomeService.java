package com.example.budgetapp.service;

import com.example.budgetapp.model.Income;
import com.example.budgetapp.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class IncomeService {
    private final IncomeRepository incomeRepository;

    public IncomeService(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    public Income addIncome(Income income) {
        return incomeRepository.save(income);
    }

    public List<Income> getAllIncome() {
        return incomeRepository.findAll();
    }

    public Income getIncomeById(Long id) {
        return incomeRepository.findById(id).orElse(null);
    }

    public List<Income> getIncomeBySource(String source) {
        return incomeRepository.findBySource(source);
    }

    public List<Income> getIncomeByDateRange(LocalDate startDate, LocalDate endDate) {
        return incomeRepository.findByDateBetween(startDate, endDate);
    }

    public List<Income> getIncomeByAmountGreaterThan(Double amount) {
        return incomeRepository.findByAmountGreaterThan(amount);
    }

    public Income updateIncome(Long id, Income income) {
        if (incomeRepository.existsById(id)) {
            income.setId(id);
            return incomeRepository.save(income);
        }
        return null;
    }

    public void deleteIncome(Long id) {
        incomeRepository.deleteById(id);
    }
}