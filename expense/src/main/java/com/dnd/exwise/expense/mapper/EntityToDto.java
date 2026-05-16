package com.dnd.exwise.expense.mapper;


import com.dnd.exwise.expense.dto.ExpenseResponseDto;
import com.dnd.exwise.expense.entity.ExpenseEntity;

import java.util.List;

public class EntityToDto {

    public static ExpenseResponseDto expenseEntityTODto(ExpenseEntity expense) {
        return new ExpenseResponseDto(expense.getExpenseId(), expense.getTitle(), expense.getAmount(), expense.getCategory(), expense.getUserId(), expense.getCreatedAt());
    }

    public static List<ExpenseResponseDto> expenseEntityTODto(List<ExpenseEntity> expenses) {
        return expenses.stream().map(expense -> EntityToDto.expenseEntityTODto(expense)).toList();
    }
}
