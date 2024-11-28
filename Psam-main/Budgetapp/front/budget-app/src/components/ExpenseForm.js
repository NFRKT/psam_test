// src/components/ExpenseForm.js

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { categorizeExpense } from "../utils/categorizer"; // Funkcja kategoryzująca wydatki

const ExpenseForm = () => {
  const [expenseName, setExpenseName] = useState("");
  const [expenseAmount, setExpenseAmount] = useState("");
  const [category, setCategory] = useState("");
  const [subCategory, setSubCategory] = useState("");
  const navigate = useNavigate();

  const handleExpenseNameChange = (e) => {
    setExpenseName(e.target.value);
  };

  const handleExpenseAmountChange = (e) => {
    setExpenseAmount(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    const { category, subCategory } = categorizeExpense(expenseName); // Przypisanie kategorii i podkategorii

    setCategory(category);
    setSubCategory(subCategory);

    // Przechowywanie wydatku w localStorage
    const existingExpenses = JSON.parse(localStorage.getItem("expenses")) || [];
    existingExpenses.push({ name: expenseName, amount: expenseAmount, category, subCategory });
    localStorage.setItem("expenses", JSON.stringify(existingExpenses));

    navigate("/overview");
  };

  return (
    <div>
      <h2>Dodaj Wydatek</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={expenseName}
          onChange={handleExpenseNameChange}
          placeholder="Nazwa wydatku"
          required
        />
        <input
          type="number"
          value={expenseAmount}
          onChange={handleExpenseAmountChange}
          placeholder="Kwota"
          required
        />
        <button type="submit">Dodaj Wydatek</button>
      </form>
      {category && <p>Kategoria: {category} - Podkategoria: {subCategory}</p>}
    </div>
  );
};

export default ExpenseForm;
