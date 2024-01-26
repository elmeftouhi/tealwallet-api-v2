package com.yassinesmac.api.dto;

public record Todo(
        Integer userId,
        Integer id,
        String title,
        Boolean completed
) {
}
