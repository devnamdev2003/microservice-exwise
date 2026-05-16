package com.dnd.exwise.expense.controller;

import com.dnd.exwise.expense.dto.ExpenseRequestDto;
import com.dnd.exwise.expense.dto.ExpenseResponseDto;
import com.dnd.exwise.expense.service.ExpenseService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public ExpenseResponseDto save(@Valid @RequestBody ExpenseRequestDto expense) {
        return expenseService.save(expense);
    }

    @GetMapping("/all")
    public List<ExpenseResponseDto> getAll() {
        return expenseService.getAll();
    }

    @GetMapping("/{expenseId}")
    public ExpenseResponseDto getById(@PathVariable Long expenseId) {
        return expenseService.getById(expenseId);
    }

    @PutMapping("/{expenseId}")
    public ExpenseResponseDto update(@Valid @RequestBody ExpenseRequestDto expense, @PathVariable Long expenseId) {
        return expenseService.update(expense, expenseId);
    }

    @DeleteMapping("/{expenseId}")
    public ExpenseResponseDto delete(@PathVariable Long expenseId) {
        return expenseService.delete(expenseId);
    }

    @PostMapping("/save-bulk")
    public List<ExpenseResponseDto> saveBulk(@Valid @RequestBody List<ExpenseRequestDto> expenses) {
        return expenseService.saveBulk(expenses);
    }

    @DeleteMapping("/delete-bulk")
    public String deleteAll() {
        return expenseService.deleteAll();
    }
}