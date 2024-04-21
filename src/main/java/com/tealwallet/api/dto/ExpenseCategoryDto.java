package com.tealwallet.api.dto;

import com.tealwallet.api.entity.Expense;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ExpenseCategoryDto{
    Long id;
    String name;
    String icon;
    Integer level;
    Boolean isActive;
    LocalDateTime deletedAt;
    Integer deletedBy;
    Set<ExpenseDto> expenses;

    public ExpenseCategoryDto() {
    }

    public ExpenseCategoryDto(Long id, String name, String icon, Integer level, Boolean isActive, LocalDateTime deletedAt, Integer deletedBy, Set<ExpenseDto> expenses) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.level = level;
        this.isActive = isActive;
        this.deletedAt = deletedAt;
        this.deletedBy = deletedBy;
        this.expenses = expenses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Set<ExpenseDto> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<ExpenseDto> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "ExpenseCategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", isActive=" + isActive +
                ", deletedAt=" + deletedAt +
                ", deletedBy=" + deletedBy +
                ", expenses=" + expenses +
                '}';
    }
}
