package com.tealwallet.api.dto;

import java.time.LocalDateTime;
import java.util.Set;

public class ExpenseCategoryCreateDto {
    Long id;
    String name;
    String icon;
    Integer level;
    Boolean isActive;

    public ExpenseCategoryCreateDto() {
    }

    public ExpenseCategoryCreateDto(Long id, String name, String icon, Integer level, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.level = level;
        this.isActive = isActive;
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

    @Override
    public String toString() {
        return "ExpenseCategoryCreateDto{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", level=" + level +
                ", isActive=" + isActive +
                '}';
    }
}
