package com.dnd.exwise.expense.mapper;

import com.dnd.exwise.expense.dto.ExpenseRequestDto;
import com.dnd.exwise.expense.entity.ExpenseEntity;

public class DtoToEntity {

    public static ExpenseEntity expenseReqDtoToEntity(ExpenseRequestDto expense) {
        return new ExpenseEntity(expense.getTitle(), expense.getAmount(), expense.getCategory(), expense.getUserId());
    }
}
