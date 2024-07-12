package com.challange18.wit.controller;

import com.challange18.wit.dto.CategoryResponse;
import com.challange18.wit.entity.Category;
import com.challange18.wit.service.CategoryService;
import com.challange18.wit.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
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
        return EntityConverter.findResult(categoryService.save(category));
    }
    @GetMapping("/{id}")
    public CategoryResponse get(@PathVariable long id){
        Category foundCategory = categoryService.findById(id);
        return EntityConverter.findResult(categoryService.findById(id));
    }

    @GetMapping("/")
    public List<CategoryResponse> getAll(){
        return EntityConverter.findResults(categoryService.findAll());
    }

    @PutMapping("/{id}")
    public CategoryResponse save(@RequestBody Category category, @PathVariable long id){
        Category foundCategory = categoryService.findById(id);
        if(foundCategory != null ){
            category.setId(id);
            return EntityConverter.findResult(categoryService.save(category));
        }
        // TODO exception
        return null;
    }


    /*
    @DeleteMapping("/{id}")
    public CategoryResponse remove(@PathVariable long id){
        return EntityConverter.findResult(categoryService.delete(id));
    }*/

}
