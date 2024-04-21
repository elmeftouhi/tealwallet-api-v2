package com.tealwallet.api.repository;

import com.tealwallet.api.entity.Expense;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends ListCrudRepository<Expense, Long> {
}
