import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const BudgetForm = () => {
  const [budget, setBudget] = useState("");
  const navigate = useNavigate();

  const handleBudgetChange = (e) => {
    setBudget(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Przechowywanie budżetu w lokalnym stanie lub bazie danych
    localStorage.setItem("budget", budget);
    navigate("/overview"); // Po zapisaniu danych przechodzimy do podglądu
  };

  return (
    <div>
      <h2>Ustaw Budżet</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={budget}
          onChange={handleBudgetChange}
          placeholder="Wpisz kwotę budżetu"
          required
        />
        <button type="submit">Zapisz Budżet</button>
      </form>
    </div>
  );
};

export default BudgetForm;
