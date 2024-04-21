package com.tealwallet.api.service;

import com.tealwallet.api.dto.ExpenseDto;
import com.tealwallet.api.entity.Expense;
import com.tealwallet.api.entity.ExpenseCategory;
import com.tealwallet.api.repository.ExpenseCategoryRepository;
import com.tealwallet.api.repository.ExpenseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ModelMapper modelMapper) {
        this.expenseRepository = expenseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ExpenseDto> getAll() {
        List<Expense> expenses =  expenseRepository.findAll();

        return expenses.stream()
                .map(expense -> modelMapper.map(expense, ExpenseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto save(ExpenseDto expenseDto) {
        Expense newExpense = modelMapper.map(expenseDto, Expense.class);
        Expense savedExpense = expenseRepository.save(newExpense);
        return modelMapper.map(savedExpense, ExpenseDto.class);
    }
}
