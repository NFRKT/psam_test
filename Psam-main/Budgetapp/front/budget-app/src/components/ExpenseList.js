// src/components/ExpenseList.js
import React, { useState, useEffect } from "react";

const ExpenseList = () => {
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    // Pobierz dane wydatków z localStorage
    const storedExpenses = JSON.parse(localStorage.getItem("expenses")) || [];
    setExpenses(storedExpenses);
  }, []);

  return (
    <div>
      <h2>Lista Wydatków</h2>
      <ul>
        {expenses.map((expense, index) => (
          <li key={index}>
            {expense.name} - Kategoria: {expense.category} - Kwota: {expense.amount}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ExpenseList;
