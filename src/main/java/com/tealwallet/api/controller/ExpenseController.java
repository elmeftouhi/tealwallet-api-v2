package com.tealwallet.api.controller;

import com.tealwallet.api.dto.ExpenseDto;
import com.tealwallet.api.entity.Expense;
import com.tealwallet.api.entity.ExpenseCategory;
import com.tealwallet.api.service.ExpenseCategoryService;
import com.tealwallet.api.service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("${app.url}/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping()
    List<ExpenseDto> getAll(){
        return expenseService.getAll();
    }

    @PostMapping("")
    ExpenseDto create(@RequestBody ExpenseDto expenseDto){
        //System.out.println(expenseDto.toString());
        return expenseService.save(expenseDto);
    }
}
