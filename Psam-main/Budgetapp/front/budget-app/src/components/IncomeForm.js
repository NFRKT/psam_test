import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const IncomeForm = () => {
  const [income, setIncome] = useState("");
  const navigate = useNavigate();

  const handleIncomeChange = (e) => {
    setIncome(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    // Zapisanie przychodu w localStorage
    const existingIncomes = JSON.parse(localStorage.getItem("incomes")) || [];
    existingIncomes.push(income);
    localStorage.setItem("incomes", JSON.stringify(existingIncomes));
    navigate("/overview");
  };

  return (
    <div>
      <h2>Dodaj Przychód</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={income}
          onChange={handleIncomeChange}
          placeholder="Wpisz kwotę przychodu"
          required
        />
        <button type="submit">Dodaj Przychód</button>
      </form>
    </div>
  );
};

export default IncomeForm;
