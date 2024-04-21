package com.tealwallet.api.service;

import com.tealwallet.api.entity.ExpenseCategory;

import java.util.List;
import java.util.Optional;


public interface ExpenseCategoryService {
     List<ExpenseCategory> getAll();
     List<ExpenseCategory> getAllWithDetails();

     ExpenseCategory save(ExpenseCategory expenseCategory);

     Integer count();

     Optional<ExpenseCategory> findById(Long id);

     void updateLevel(Integer newLevel);
}
