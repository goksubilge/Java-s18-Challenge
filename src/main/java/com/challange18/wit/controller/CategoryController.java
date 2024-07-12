package com.challange18.wit.controller;

import com.challange18.wit.dto.CategoryResponse;
import com.challange18.wit.entity.Category;
import com.challange18.wit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/")
    public CategoryResponse save(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        return new CategoryResponse(savedCategory.getId(), savedCategory.getName());
    }
    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id){
        Category foundCategory = categoryService.findById(id);
        return new CategoryResponse(foundCategory.getId(), foundCategory.getName());
    }
}
