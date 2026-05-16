package com.dnd.exwise.expense.serviceImpl;

import com.dnd.exwise.expense.dto.ExpenseRequestDto;
import com.dnd.exwise.expense.dto.ExpenseResponseDto;
import com.dnd.exwise.expense.entity.ExpenseEntity;
import com.dnd.exwise.expense.exception.ExpenseException;
import com.dnd.exwise.expense.mapper.DtoToEntity;
import com.dnd.exwise.expense.mapper.EntityToDto;
import com.dnd.exwise.expense.repository.ExpenseRepository;
import com.dnd.exwise.expense.service.ExpenseService;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public ExpenseResponseDto save(ExpenseRequestDto expense) {
        ExpenseEntity newExpense = expenseRepository.save(DtoToEntity.expenseReqDtoToEntity(expense));
        return EntityToDto.expenseEntityTODto(newExpense);
    }

    @Override
    public ExpenseResponseDto getById(Long expenseId) {
        ExpenseEntity expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ExpenseException("expense not found"));
        return EntityToDto.expenseEntityTODto(expense);
    }

    @Override
    public List<ExpenseResponseDto> getAll() {
        List<ExpenseEntity> expense = expenseRepository.findAll();
        return EntityToDto.expenseEntityTODto(expense);
    }

    @Override
    public ExpenseResponseDto update(ExpenseRequestDto expense, Long expenseId) {
        ExpenseEntity existingExpense = expenseRepository.findById(expenseId).orElseThrow(() -> new ExpenseException("expense not found"));
        existingExpense.setTitle(expense.getTitle());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setUserId(expense.getUserId());
        expenseRepository.save(existingExpense);
        return EntityToDto.expenseEntityTODto(existingExpense);
    }

    @Override
    public ExpenseResponseDto delete(Long expenseId) {
        ExpenseEntity existingExpense = expenseRepository.findById(expenseId).orElseThrow(() -> new ExpenseException("expense not found"));
        expenseRepository.delete(existingExpense);
        return EntityToDto.expenseEntityTODto(existingExpense);
    }

    @Override
    public String deleteAll() {
        expenseRepository.deleteAll();
        return "Deleted All!";
    }

    @Transactional
    @Override
    public List<ExpenseResponseDto> saveBulk(List<ExpenseRequestDto> expenses) {
        List<ExpenseEntity> newExpenses = new ArrayList<>();
        for (ExpenseRequestDto expense : expenses) {
            ExpenseEntity newExpense = DtoToEntity.expenseReqDtoToEntity(expense);
            expenseRepository.save(newExpense);
            newExpenses.add(newExpense);
        }
        return EntityToDto.expenseEntityTODto(newExpenses);
    }
}