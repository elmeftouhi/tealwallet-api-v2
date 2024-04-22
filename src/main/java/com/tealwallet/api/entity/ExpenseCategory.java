package com.tealwallet.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "expense_categories")

public class ExpenseCategory{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @NotBlank(message = "Name should not be empty")
        private String name;
        @NotNull
        @Min(1)
        private Integer level;
        private Boolean isActive;
        private String icon;

        private LocalDateTime deletedAt;

        private Long deletedBy;

        @Column(name = "expenses")
        @OneToMany(mappedBy = "expenseCategory", fetch = FetchType.LAZY)
        private Set<Expense> expenses = new HashSet<>();
        public ExpenseCategory() {
        }

        public ExpenseCategory(Long id, String name, Integer level, Boolean isActive, String icon, LocalDateTime deletedAt, Long deletedBy, Set<Expense> expenses) {
                this.id = id;
                this.name = name;
                this.level = level;
                this.isActive = isActive;
                this.icon = icon;
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

        public String getIcon() {
                return icon;
        }

        public void setIcon(String icon) {
                this.icon = icon;
        }

        public Set<Expense> getExpenses() {
                return expenses;
        }

        public LocalDateTime getDeletedAt() {
                return deletedAt;
        }

        public void setDeletedAt(LocalDateTime deletedAt) {
                this.deletedAt = deletedAt;
        }

        public Long getDeletedBy() {
                return deletedBy;
        }

        public void setDeletedBy(Long deletedBy) {
                this.deletedBy = deletedBy;
        }

        @Override
        public String toString() {
                return "ExpenseCategory{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", level=" + level +
                        ", isActive=" + isActive +
                        ", icon='" + icon + '\'' +
                        ", expenses=" + expenses +
                        '}';
        }
}


