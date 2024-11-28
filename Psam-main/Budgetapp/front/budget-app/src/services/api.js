import axios from "axios";

const API_URL = "http://localhost:8080/api"; // Zakładając, że backend działa na porcie 8080

// Funkcje do zarządzania budżetami
export const getBudgets = () => axios.get(`${API_URL}/budget`);
export const addBudget = (budget) => axios.post(`${API_URL}/budget`, budget);
export const updateBudget = (id, budget) =>
  axios.put(`${API_URL}/budget/${id}`, budget);
export const deleteBudget = (id) => axios.delete(`${API_URL}/budget/${id}`);

// Funkcje do zarządzania wydatkami
export const getExpenses = () => axios.get(`${API_URL}/expenses`);
export const addExpense = (expense) =>
  axios.post(`${API_URL}/expenses`, expense);
export const updateExpense = (id, expense) =>
  axios.put(`${API_URL}/expenses/${id}`, expense);
export const deleteExpense = (id) => axios.delete(`${API_URL}/expenses/${id}`);

// Funkcje do zarządzania przychodami
export const getIncome = () => axios.get(`${API_URL}/income`);
export const addIncome = (income) => axios.post(`${API_URL}/income`, income);
export const updateIncome = (id, income) =>
  axios.put(`${API_URL}/income/${id}`, income);
export const deleteIncome = (id) => axios.delete(`${API_URL}/income/${id}`);
