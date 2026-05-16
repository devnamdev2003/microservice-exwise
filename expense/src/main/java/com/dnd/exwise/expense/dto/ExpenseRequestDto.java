package com.dnd.exwise.expense.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ExpenseRequestDto {

    @NotBlank(message = "title is required!")
    private String title;

    @NotNull(message = "amount is required!")
    private Double amount;

    @NotBlank(message = "category is required!")
    private String category;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    public ExpenseRequestDto(String title, Double amount, String category, Long userId) {
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}