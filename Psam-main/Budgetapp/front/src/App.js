import React from "react";
import { BrowserRouter as Router, Route, Routes, Link } from "react-router-dom";
import BudgetForm from "./components/BudgetForm";
import IncomeForm from "./components/IncomeForm";
import ExpenseForm from "./components/ExpenseForm";
import BudgetOverview from "./components/BudgetOverview";
import ExpenseList from "./components/ExpenseList";  // Import nowej strony

const App = () => {
  return (
    <Router>
      <div style={{ padding: "20px" }}>
        <h1>Zarządzanie Budżetem</h1>

        {/* Nawigacja - przyciski kierujące do różnych stron */}
        <div style={{ marginBottom: "20px" }}>
          <Link to="/add-budget">
            <button style={{ marginRight: "10px" }}>Dodaj Budżet</button>
          </Link>
          <Link to="/add-income">
            <button style={{ marginRight: "10px" }}>Dodaj Przychód</button>
          </Link>
          <Link to="/add-expense">
            <button style={{ marginRight: "10px" }}>Dodaj Wydatek</button>
          </Link>
          <Link to="/overview">
            <button>Podgląd Budżetu</button>
          </Link>
          <Link to="/expense-list">
            <button>Lista Wydatków</button> {/* Dodany przycisk */}
          </Link>
        </div>

        {/* Routing */}
        <Routes>
          <Route path="/add-budget" element={<BudgetForm />} />
          <Route path="/add-income" element={<IncomeForm />} />
          <Route path="/add-expense" element={<ExpenseForm />} />
          <Route path="/overview" element={<BudgetOverview />} />
          <Route path="/expense-list" element={<ExpenseList />} /> {/* Nowa trasa */}
        </Routes>
      </div>
    </Router>
  );
};

export default App;
