package com.tealwallet.api.dto;

import com.tealwallet.api.entity.ExpenseCategory;

import java.time.LocalDateTime;
import java.util.Date;

public class ExpenseDto{
    Long id;
    String expenseDetail;
    Double amount;
    Date expenseDate;
    Integer createdBy;
    LocalDateTime createdAt;
    Integer updatedBy;
    LocalDateTime updatedAt;
    Integer deletedBy;
    LocalDateTime deletedAt;
    ExpenseCategoryDto category;
    public ExpenseDto() {
    }

    public ExpenseDto(Long id, String expenseDetail, Double amount, Date expenseDate, Integer createdBy, LocalDateTime createdAt, Integer updatedBy, LocalDateTime updatedAt, Integer deletedBy, LocalDateTime deletedAt, ExpenseCategoryDto category) {
        this.id = id;
        this.expenseDetail = expenseDetail;
        this.amount = amount;
        this.expenseDate = expenseDate;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedBy = updatedBy;
        this.updatedAt = updatedAt;
        this.deletedBy = deletedBy;
        this.deletedAt = deletedAt;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseDetail() {
        return expenseDetail;
    }

    public void setExpenseDetail(String expenseDetail) {
        this.expenseDetail = expenseDetail;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Date expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public ExpenseCategoryDto getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategoryDto category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", expenseDetail='" + expenseDetail + '\'' +
                ", amount=" + amount +
                ", expenseDate=" + expenseDate +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedBy=" + updatedBy +
                ", updatedAt=" + updatedAt +
                ", deletedBy=" + deletedBy +
                ", deletedAt=" + deletedAt +
                ", category=" + category +
                '}';
    }
}
