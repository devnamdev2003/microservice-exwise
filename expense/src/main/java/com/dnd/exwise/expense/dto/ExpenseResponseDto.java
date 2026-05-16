package com.dnd.exwise.expense.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpenseResponseDto {

    private Long expenseId;
    private String title;
    private Double amount;
    private String category;
    private Long userId;
    private LocalDateTime createdAt;

    public ExpenseResponseDto(Long expenseId, String title, Double amount, String category, Long userId, LocalDateTime createdAt) {
        this.expenseId = expenseId;
        this.title = title;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public Long getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}