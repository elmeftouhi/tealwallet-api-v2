package com.yassinesmac.api.service;

import com.yassinesmac.api.dto.ExpenseCategory;
import com.yassinesmac.api.repository.ExpenseCategoryRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseCategoryImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryImpl(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public List<ExpenseCategory> getAll() {
        return expenseCategoryRepository.findAllByOrderByLevelAsc();
    }

    @Override
    public ExpenseCategory save(ExpenseCategory expenseCategory) {
        return expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    @Query("SELECT count(id) FROM expense_categories")
    public Integer count() {
        return Math.toIntExact(expenseCategoryRepository.count());
    }

    @Override
    public Optional<ExpenseCategory> findById(Long id) {
        return expenseCategoryRepository.findById(id);
    }
}
