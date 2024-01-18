package com.yassinesmac.api.service;

import com.yassinesmac.api.dto.ExpenseCategory;

import java.util.List;
import java.util.Optional;


public interface ExpenseCategoryService {
     List<ExpenseCategory> getAll();

     ExpenseCategory save(ExpenseCategory expenseCategory);

     Integer count();

     Optional<ExpenseCategory> findById(Long id);
}
