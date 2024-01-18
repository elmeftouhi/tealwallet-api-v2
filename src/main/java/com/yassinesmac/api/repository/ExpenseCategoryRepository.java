package com.yassinesmac.api.repository;

import com.yassinesmac.api.dto.ExpenseCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseCategoryRepository extends ListCrudRepository<ExpenseCategory, Long>{
    List<ExpenseCategory> findAllByOrderByLevelAsc();
}
