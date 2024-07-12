package com.challange18.wit.service;

import com.challange18.wit.entity.Category;

import java.util.List;

public interface CategoryService {
    Category findById(long id);
    Category save(Category category);

}
