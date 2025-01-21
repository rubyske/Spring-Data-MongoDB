package com.programmingduthe.springbootmongodb.config;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.programmingduthe.springbootmongodb.model.Expense;
import com.programmingduthe.springbootmongodb.model.ExpenseCategory;
import com.programmingduthe.springbootmongodb.repository.ExpenseRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DataBaseChangeLog {
    @ChangeSet(order = "001", id = "seedDataBase", author = "Dude")
    public void seedDataBase(ExpenseRepository expenseRepository){
        List<Expense> expenseList = new ArrayList<>();
        expenseList.add(createNewExpense("MCD", ExpenseCategory.RESTAURANT, BigDecimal.valueOf(20) ));
        expenseList.add(createNewExpense("BEEF", ExpenseCategory.RESTAURANT, BigDecimal.valueOf(50) ));
        expenseList.add(createNewExpense("DISNEY", ExpenseCategory.ENTERTAIMENT, BigDecimal.valueOf(20) ));
        expenseRepository.insert(expenseList);
    }

    private Expense createNewExpense(String expenseName, ExpenseCategory expenseCategory, BigDecimal expenseAmount){
        Expense expense = new Expense();
        expense.setExpenseName(expenseName);
        expense.setExpenseCategory(expenseCategory);
        expense.setExpenseAmount(expenseAmount);
        return expense;
    }
}
