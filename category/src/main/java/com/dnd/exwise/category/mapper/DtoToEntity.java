package com.dnd.exwise.category.mapper;

import com.dnd.exwise.category.dto.CategoryRequestDto;
import com.dnd.exwise.category.entity.CategoryEntity;

public class DtoToEntity {

    public static CategoryEntity categoryReqDtoToEntity(CategoryRequestDto category) {
        return new CategoryEntity(category.getCategoryName(), category.getCategoryDescription(), category.getUserId());
    }
}