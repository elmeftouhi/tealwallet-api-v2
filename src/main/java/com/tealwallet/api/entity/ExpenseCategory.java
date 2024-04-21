package com.tealwallet.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

        @Column(name = "expenses")
        @OneToMany(mappedBy = "expenseCategory", fetch = FetchType.LAZY)
        private Set<Expense> expenses = new HashSet<>();
        public ExpenseCategory() {
        }

        public ExpenseCategory(Long id, String name, Integer level, Boolean isActive, String icon) {
                this.id = id;
                this.name = name;
                this.level = level;
                this.isActive = isActive;
                this.icon = icon;
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


