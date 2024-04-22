package com.tealwallet.api.controller;

import com.tealwallet.api.dto.ExpenseCategoryCreateDto;
import com.tealwallet.api.entity.ExpenseCategory;
import com.tealwallet.api.service.ExpenseCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"${app.url}/expense-categories"})
@Validated
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;
    private final Logger logger = LoggerFactory.getLogger(ExpenseCategoryController.class);

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }
    @GetMapping("")
    List<ExpenseCategory> get(@RequestParam(required = false) Boolean withDetails){
        logger.info("Get all Expense Categories is called by the client");
        if(withDetails != null){
            logger.info("************ " + withDetails);
        }
        return expenseCategoryService.getAll();
    }

    @PostMapping("")
    ExpenseCategory create(@RequestBody ExpenseCategoryCreateDto expenseCategory){
        logger.info("Create a new Expense Category is called by the client");

        Integer count = expenseCategoryService.count();
        if(expenseCategory.getLevel() == null){
            expenseCategory.setLevel(count + 1);
        }else{
            expenseCategoryService.updateLevel(expenseCategory.getLevel());
        }

        return expenseCategoryService.save(expenseCategory);
    }

    @PutMapping("/{id}")
    ExpenseCategory update(@PathVariable Long id, @RequestBody ExpenseCategoryCreateDto expenseCategory) {
        expenseCategory.setId(id);
        return expenseCategoryService.save(expenseCategory);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        expenseCategoryService.delete(id);
    }

    @GetMapping("/{id}")
    Optional<ExpenseCategory> getById(@PathVariable Long id) {
        return expenseCategoryService.findById(id);
    }

}
