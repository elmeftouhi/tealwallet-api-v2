package com.tealwallet.api.repository;

import com.tealwallet.api.entity.ExpenseCategory;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseCategoryRepository extends ListCrudRepository<ExpenseCategory, Long>{
    List<ExpenseCategory> findAllByOrderByLevelAsc();

    List<ExpenseCategory> findByLevelGreaterThanEqual(Integer level);
}
