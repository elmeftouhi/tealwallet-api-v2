package com.yassinesmac.api.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
        public Integer getLevel() {
                return level;
        }

        public void setLevel(Integer level) {
                this.level = level;
        }

        private Integer level;

        public ExpenseCategory() {
        }
        public ExpenseCategory(Long id, String name) {
                this.id = id;
                this.name = name;
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

}


