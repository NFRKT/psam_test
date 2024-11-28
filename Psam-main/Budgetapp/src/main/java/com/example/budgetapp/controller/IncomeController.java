package com.example.budgetapp.controller;

import com.example.budgetapp.model.Income;
import com.example.budgetapp.service.IncomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/income")
public class IncomeController {
    private final IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    // Dodawanie nowego przychodu
    @PostMapping
    public ResponseEntity<Income> addIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.addIncome(income);
        return ResponseEntity.ok(savedIncome);
    }

    // Pobieranie wszystkich przychodów
    @GetMapping
    public ResponseEntity<List<Income>> getAllIncome() {
        List<Income> incomes = incomeService.getAllIncome();
        return ResponseEntity.ok(incomes);
    }

    // Pobieranie przychodu po ID
    @GetMapping("/{id}")
    public ResponseEntity<Income> getIncomeById(@PathVariable Long id) {
        Income income = incomeService.getIncomeById(id);
        return income != null ? ResponseEntity.ok(income) : ResponseEntity.notFound().build();
    }

    // Aktualizacja przychodu
    @PutMapping("/{id}")
    public ResponseEntity<Income> updateIncome(@PathVariable Long id, @RequestBody Income income) {
        Income updatedIncome = incomeService.updateIncome(id, income);
        return updatedIncome != null ? ResponseEntity.ok(updatedIncome) : ResponseEntity.notFound().build();
    }

    // Usuwanie przychodu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIncome(@PathVariable Long id) {
        incomeService.deleteIncome(id);
        return ResponseEntity.noContent().build();
    }
}
