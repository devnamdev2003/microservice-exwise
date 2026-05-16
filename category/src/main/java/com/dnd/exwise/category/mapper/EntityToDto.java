package com.dnd.exwise.category.mapper;

import com.dnd.exwise.category.dto.CategoryResponseDto;
import com.dnd.exwise.category.entity.CategoryEntity;

import java.util.List;

public class EntityToDto {

    public static CategoryResponseDto categoryEntityTODto(CategoryEntity category) {
        return new CategoryResponseDto(category.getCategoryId(), category.getCategoryName(), category.getCategoryDescription(), category.getUserId(), category.getCreatedAt());
    }

    public static List<CategoryResponseDto> categoryEntityTODto(List<CategoryEntity> categories) {
        return categories.stream().map(categorie -> EntityToDto.categoryEntityTODto(categorie)).toList();
    }
}