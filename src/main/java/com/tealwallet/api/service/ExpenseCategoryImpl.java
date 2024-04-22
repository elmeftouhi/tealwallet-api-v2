package com.tealwallet.api.service;

import com.tealwallet.api.dto.ExpenseCategoryCreateDto;
import com.tealwallet.api.entity.ExpenseCategory;
import com.tealwallet.api.repository.ExpenseCategoryRepository;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseCategoryImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseCategoryImpl(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public List<ExpenseCategory> getAll() {
        return expenseCategoryRepository.findAllByOrderByLevelAsc()
                .stream().filter(e -> e.getDeletedAt()==null).collect(Collectors.toList());
    }

    @Override
    public List<ExpenseCategory> getAllWithDetails() {
        return null;
    }

    @Override
    public ExpenseCategory save(ExpenseCategoryCreateDto expenseCategoryCreateDto) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategoryCreateDto.getName());
        expenseCategory.setActive(expenseCategoryCreateDto.getActive());
        expenseCategory.setIcon(expenseCategoryCreateDto.getIcon());
        expenseCategory.setLevel(expenseCategoryCreateDto.getLevel());
        return expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    @Query("SELECT count(id) FROM expense_categories")
    public Integer count() {
        return Math.toIntExact(expenseCategoryRepository.count());
    }

    @Override
    public Optional<ExpenseCategory> findById(Long id) {

        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
        if(expenseCategory.isPresent()){
            if(expenseCategory.get().getDeletedAt() == null){
                return expenseCategory;
            }else{
                return Optional.empty();
            }
        }else {
            return Optional.empty();
        }
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

    @Override
    public void delete(Long id) {
        // Implementing soft delete
        // 1 check if the expense category with the given Id exists
        Optional<ExpenseCategory> expenseCategory = expenseCategoryRepository.findById(id);
        if (expenseCategory.isPresent()){
            expenseCategory.get().setDeletedAt(LocalDateTime.now());
            expenseCategory.get().setDeletedBy(1L);
            expenseCategoryRepository.save(expenseCategory.get());
        }else {
            throw new RuntimeException("Not Found");
        }

    }
}
