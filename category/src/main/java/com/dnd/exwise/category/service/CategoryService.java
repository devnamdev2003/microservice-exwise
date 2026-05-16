package com.dnd.exwise.category.service;

import com.dnd.exwise.category.dto.CategoryRequestDto;
import com.dnd.exwise.category.dto.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    CategoryResponseDto save(CategoryRequestDto category);

    CategoryResponseDto getById(Long categoryId);

    List<CategoryResponseDto> getAll();

    CategoryResponseDto update(CategoryRequestDto category, Long categoryId);

    CategoryResponseDto delete(Long categoryId);

    String deleteAll();

    List<CategoryResponseDto> saveBulk(List<CategoryRequestDto> categories);
}