package com.dnd.exwise.expense.service;

import com.dnd.exwise.expense.dto.ExpenseRequestDto;
import com.dnd.exwise.expense.dto.ExpenseResponseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseResponseDto save(ExpenseRequestDto expense);

    List<ExpenseResponseDto> getAll();

    ExpenseResponseDto getById(Long expenseId);

    ExpenseResponseDto update(ExpenseRequestDto expense, Long expenseId);

    ExpenseResponseDto delete(Long expenseId);

    List<ExpenseResponseDto> saveBulk(List<ExpenseRequestDto> expenses);

    String deleteAll();
}