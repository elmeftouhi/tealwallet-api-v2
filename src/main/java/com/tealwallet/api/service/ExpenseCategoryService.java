package com.tealwallet.api.service;

import com.tealwallet.api.dto.ExpenseCategoryCreateDto;
import com.tealwallet.api.entity.ExpenseCategory;

import java.util.List;
import java.util.Optional;


public interface ExpenseCategoryService {
     List<ExpenseCategory> getAll();
     List<ExpenseCategory> getAllWithDetails();

     ExpenseCategory save(ExpenseCategoryCreateDto expenseCategoryCreateDto);

     Integer count();

     Optional<ExpenseCategory> findById(Long id);

     void updateLevel(Integer newLevel);

     void delete(Long id);
}
