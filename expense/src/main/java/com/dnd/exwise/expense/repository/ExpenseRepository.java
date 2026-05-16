package com.dnd.exwise.expense.repository;

import com.dnd.exwise.expense.entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {

    List<ExpenseEntity> findByUserId(Long userId);

    List<ExpenseEntity> findByCategory(String category);
}