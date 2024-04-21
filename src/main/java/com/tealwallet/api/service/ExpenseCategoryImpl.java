package com.tealwallet.api.service;

import com.tealwallet.api.entity.ExpenseCategory;
import com.tealwallet.api.repository.ExpenseCategoryRepository;
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
    public List<ExpenseCategory> getAllWithDetails() {
        return null;
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

    @Override
    public void updateLevel(Integer newLevel){
        List<ExpenseCategory> categories = expenseCategoryRepository.findByLevelGreaterThanEqual(newLevel);
        categories.forEach(c -> System.out.println(c.toString()));

        /*
        List<ExpenseCategory> newList = categories.stream()
                .map(c -> new ExpenseCategory(c.getId(), c.getName(), c.getLevel()+1))
                .toList();  //.forEach(c -> {c.setLevel(c.getLevel() + 1);});
        newList.forEach(c -> System.out.println(c.toString()));
        expenseCategoryRepository.saveAll(newList);
        System.out.println("******counter : " + (long) categories.size());
        *
         */
    }
}
