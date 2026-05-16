package com.dnd.exwise.category.serviceImpl;

import com.dnd.exwise.category.dto.CategoryRequestDto;
import com.dnd.exwise.category.dto.CategoryResponseDto;
import com.dnd.exwise.category.entity.CategoryEntity;
import com.dnd.exwise.category.exception.CategoryException;
import com.dnd.exwise.category.mapper.DtoToEntity;
import com.dnd.exwise.category.mapper.EntityToDto;
import com.dnd.exwise.category.repository.CategoryRepository;
import com.dnd.exwise.category.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDto save(CategoryRequestDto category) {
        CategoryEntity newCategory=categoryRepository.save(DtoToEntity.categoryReqDtoToEntity(category));
        return EntityToDto.categoryEntityTODto(newCategory);
    }

    @Override
    public CategoryResponseDto getById(Long categoryId) {
        CategoryEntity category=categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("category not found"));
        return EntityToDto.categoryEntityTODto(category);
    }

    @Override
    public List<CategoryResponseDto> getAll() {
        List<CategoryEntity> category=categoryRepository.findAll();
        return EntityToDto.categoryEntityTODto(category);
    }

    @Override
    public CategoryResponseDto update(CategoryRequestDto category,Long categoryId) {
        CategoryEntity existingCategory=categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("category not found"));
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setCategoryDescription(category.getCategoryDescription());
        existingCategory.setUserId(category.getUserId());
        categoryRepository.save(existingCategory);
        return EntityToDto.categoryEntityTODto(existingCategory);
    }

    @Override
    public CategoryResponseDto delete(Long categoryId) {
        CategoryEntity existingCategory=categoryRepository.findById(categoryId).orElseThrow(() -> new CategoryException("category not found"));
        categoryRepository.delete(existingCategory);
        return EntityToDto.categoryEntityTODto(existingCategory);
    }

    @Override
    public String deleteAll() {
        categoryRepository.deleteAll();
        return "Deleted All!";
    }

    @Transactional
    @Override
    public List<CategoryResponseDto> saveBulk(List<CategoryRequestDto> categories) {
        List<CategoryEntity> newCategories=new ArrayList<>();
        for (CategoryRequestDto category : categories) {
            CategoryEntity newCategory=DtoToEntity.categoryReqDtoToEntity(category);
            categoryRepository.save(newCategory);
            newCategories.add(newCategory);
        }
        return EntityToDto.categoryEntityTODto(newCategories);
    }
}