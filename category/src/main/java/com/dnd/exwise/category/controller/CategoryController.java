package com.dnd.exwise.category.controller;

import com.dnd.exwise.category.dto.CategoryRequestDto;
import com.dnd.exwise.category.dto.CategoryResponseDto;
import com.dnd.exwise.category.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public CategoryResponseDto save(@Valid @RequestBody CategoryRequestDto category) {
        return categoryService.save(category);
    }

    @GetMapping("/all")
    public List<CategoryResponseDto> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/{categoryId}")
    public CategoryResponseDto getById(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @PutMapping("/{categoryId}")
    public CategoryResponseDto update(@Valid @RequestBody CategoryRequestDto category, @PathVariable Long categoryId) {
        return categoryService.update(category, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public CategoryResponseDto delete(@PathVariable Long categoryId) {
        return categoryService.delete(categoryId);
    }

    @DeleteMapping("/delete-bulk")
    public String deleteAll() {
        return categoryService.deleteAll();
    }

    @PostMapping("/save-bulk")
    public List<CategoryResponseDto> saveBulk(@Valid @RequestBody List<CategoryRequestDto> categories) {
        return categoryService.saveBulk(categories);
    }
}