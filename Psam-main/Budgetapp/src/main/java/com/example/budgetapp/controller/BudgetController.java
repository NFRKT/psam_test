package com.example.budgetapp.controller;

import com.example.budgetapp.model.Budget;
import com.example.budgetapp.service.BudgetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/budget")
public class BudgetController {

    private final BudgetService budgetService;


    public BudgetController(BudgetService budgetService) {
        this.budgetService = budgetService;
    }

    // Dodawanie nowego budżetu
    @PostMapping
    public ResponseEntity<Budget> addBudget(@RequestBody Budget budget) {
        Budget savedBudget = budgetService.addBudget(budget);
        return ResponseEntity.ok(savedBudget);
    }

    // Pobieranie wszystkich budżetów
    @GetMapping
    public ResponseEntity<List<Budget>> getAllBudgets() {
        List<Budget> budgets = budgetService.getAllBudgets();
        return ResponseEntity.ok(budgets);
    }

    // Pobieranie budżetu po ID
    @GetMapping("/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable Long id) {
        Budget budget = budgetService.getBudgetById(id);
        return budget != null ? ResponseEntity.ok(budget) : ResponseEntity.notFound().build();
    }

    // Pobieranie budżetu na podstawie kategorii i okresu
    @GetMapping("/category/{category}/period/{period}")
    public ResponseEntity<Budget> getBudgetByCategoryAndPeriod(@PathVariable String category, @PathVariable String period) {
        Budget budget = budgetService.getBudgetByCategoryAndPeriod(category, period);
        return budget != null ? ResponseEntity.ok(budget) : ResponseEntity.notFound().build();
    }

    // Aktualizacja budżetu
    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Long id, @RequestBody Budget budget) {
        Budget updatedBudget = budgetService.updateBudget(id, budget);
        return updatedBudget != null ? ResponseEntity.ok(updatedBudget) : ResponseEntity.notFound().build();
    }

    // Usuwanie budżetu
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Long id) {
        budgetService.deleteBudget(id);
        return ResponseEntity.noContent().build();
    }
}
