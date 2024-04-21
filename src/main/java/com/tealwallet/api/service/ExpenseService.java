package com.tealwallet.api.service;

import com.tealwallet.api.dto.ExpenseDto;
import com.tealwallet.api.entity.Expense;

import java.util.List;


public interface ExpenseService {
    List<ExpenseDto> getAll();

    ExpenseDto save(ExpenseDto expenseDto);
}
