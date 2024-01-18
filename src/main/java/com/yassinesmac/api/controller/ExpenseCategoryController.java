package com.yassinesmac.api.controller;

import com.yassinesmac.api.dto.ExpenseCategory;
import com.yassinesmac.api.service.ExpenseCategoryService;
import org.hibernate.annotations.NotFound;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expense-category")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }
    @GetMapping("")
    List<ExpenseCategory> get(){
        return expenseCategoryService.getAll();
    }

    @PostMapping("")
    ExpenseCategory create(@RequestBody ExpenseCategory expenseCategory){
        Integer count = expenseCategoryService.count();
        expenseCategory.setLevel(count + 1);
        return expenseCategoryService.save(expenseCategory);
    }

    @PutMapping("/{id}")
    ExpenseCategory update(@PathVariable Long id, @RequestBody ExpenseCategory expenseCategory) {

        expenseCategory.setId(id);

        return expenseCategoryService.save(expenseCategory);
    }

}
