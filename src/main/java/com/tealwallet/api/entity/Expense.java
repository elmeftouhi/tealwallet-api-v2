package com.tealwallet.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_detail")
    private String expenseDetail;

    @Column(name = "created_at")
    private LocalTime createdAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @ManyToOne()
    @JsonIgnore
    private ExpenseCategory expenseCategory;

    public Expense() {
    }

    public Expense(Long id, String expenseDetail, LocalTime createdAt, Integer createdBy, ExpenseCategory expenseCategory) {
        this.id = id;
        this.expenseDetail = expenseDetail;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.expenseCategory = expenseCategory;
    }

    public void create(){
        this.createdAt = LocalTime.now();
        this.createdBy = 1;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getexpenseDetail() {
        return expenseDetail;
    }

    public void setexpenseDetail(String expenseDetail) {
        this.expenseDetail = expenseDetail;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public ExpenseCategory getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseDetail='" + expenseDetail + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy=" + createdBy +
                ", expenseCategory=" + expenseCategory +
                '}';
    }
}
