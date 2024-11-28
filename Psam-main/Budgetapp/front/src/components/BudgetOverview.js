import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { Pie } from "react-chartjs-2"; // Wykres kołowy
import { Bar } from "react-chartjs-2"; // Wykres słupkowy
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend, ArcElement } from "chart.js"; // Importuj niezbędne elementy

// Rejestracja komponentów Chart.js
ChartJS.register(CategoryScale, LinearScale, BarElement, Title, Tooltip, Legend, ArcElement);

const BudgetOverview = () => {
  const [budget, setBudget] = useState(0);
  const [incomes, setIncomes] = useState([]);
  const [expenses, setExpenses] = useState([]);

  useEffect(() => {
    // Pobieranie danych z localStorage
    const storedBudget = localStorage.getItem("budget");
    const storedIncomes = JSON.parse(localStorage.getItem("incomes")) || [];
    const storedExpenses = JSON.parse(localStorage.getItem("expenses")) || [];

    setBudget(storedBudget);
    setIncomes(storedIncomes);
    setExpenses(storedExpenses);
  }, []);

  // Sumowanie przychodów
  const totalIncome = incomes.reduce((acc, val) => acc + parseFloat(val.amount), 0);

  // Grupowanie wydatków po kategoriach
  const groupedExpenses = expenses.reduce((acc, expense) => {
    // Upewnijmy się, że amount jest liczbą
    const amount = parseFloat(expense.amount);
    if (!acc[expense.category]) {
      acc[expense.category] = 0;
    }
    acc[expense.category] += amount;
    return acc;
  }, {});

  // Sumowanie wydatków
  const totalExpense = Object.values(groupedExpenses).reduce((acc, val) => acc + val, 0);

  // Jeśli budżet nie jest ustawiony, traktujemy go jako 0
  const totalBudget = budget ? parseFloat(budget) : 0;

  // Dane do wykresu kołowego
  const pieData = {
    labels: ["Budżet", "Przychody", "Wydatki"],
    datasets: [
      {
        data: [totalBudget, totalIncome, totalExpense],
        backgroundColor: ["#FFCE56", "#36A2EB", "#FF6384"],
      },
    ],
  };

  // Dane do wykresu słupkowego
  const barData = {
    labels: ["Budżet", "Przychody", "Wydatki"],
    datasets: [
      {
        label: "Kwota",
        data: [totalBudget, totalIncome, totalExpense],
        backgroundColor: ["#FFCE56", "#36A2EB", "#FF6384"],
      },
    ],
  };

  // Opcje wykresów - zmniejszenie wykresów
  const chartOptions = {
    responsive: true,
    maintainAspectRatio: false, // Zapewnia kontrolę nad rozmiarem wykresu
    plugins: {
      legend: {
        position: 'top',
      },
    },
    aspectRatio: 1, // Ustawienie proporcji wykresu (1 = kwadratowy)
  };

  return (
    <div>
      <h2>Podgląd Budżetu</h2>
      <p>Budżet: {totalBudget ? totalBudget : "Nie ustawiono budżetu"}</p>
      <p>Całkowite Przychody: {totalIncome}</p>
      <p>Całkowite Wydatki: {totalExpense}</p>

      <div style={{ marginBottom: "20px", height: "300px" }}>
        <h3>Wykres Kołowy</h3>
        <Pie data={pieData} options={chartOptions} />
      </div>

      <div style={{ marginBottom: "20px", height: "300px" }}>
        <h3>Wykres Słupkowy</h3>
        <Bar data={barData} options={chartOptions} />
      </div>

      <Link to="/add-budget">
        <button>Edytuj Budżet</button>
      </Link>
      <Link to="/add-income">
        <button>Dodaj Przychód</button>
      </Link>
      <Link to="/add-expense">
        <button>Dodaj Wydatek</button>
      </Link>

      <Link to="/expenses-list">
        <button>Lista Wydatków</button>
      </Link>
    </div>
  );
};

export default BudgetOverview;
