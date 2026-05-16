package com.dnd.exwise.category.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CategoryRequestDto {

    @NotBlank(message = "categoryName is required!")
    private String categoryName;


    private String categoryDescription;

    @NotNull(message = "userId is required!")
    private Long userId;

    public CategoryRequestDto(String categoryName, String categoryDescription, Long userId) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.userId = userId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}