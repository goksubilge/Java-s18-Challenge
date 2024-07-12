package com.challange18.wit.controller;

import com.challange18.wit.entity.Category;
import com.challange18.wit.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("")
    public Category save(@RequestBody Category category) {
            return categoryService.save(category);
    }
    @GetMapping("/")
    public Category get(@PathVariable long id){
        return categoryService.findById(id);
    }

}
