package com.programmingduthe.springbootmongodb.service;

import com.programmingduthe.springbootmongodb.model.Expense;
import com.programmingduthe.springbootmongodb.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    public void updateExpense(Expense expense) {
        Expense expenseToUpdate = expenseRepository.findById(expense.getId()).orElseThrow(() ->
                new RuntimeException(String.format("Expense with id %s not found", expense.getId())));

        expenseToUpdate.setExpenseName(expense.getExpenseName());
        expenseToUpdate.setExpenseCategory(expense.getExpenseCategory());
        expenseToUpdate.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expenseToUpdate);
    }

    public void deleteExpense(String id) {
         expenseRepository.deleteById(id);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) {
        return expenseRepository.findByName(name).orElseThrow(() ->
                new RuntimeException(String.format("Expense with name %s not found", name)));
    }
}
