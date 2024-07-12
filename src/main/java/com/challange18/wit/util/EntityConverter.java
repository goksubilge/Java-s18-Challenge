package com.challange18.wit.util;

import com.challange18.wit.dto.CategoryResponse;
import com.challange18.wit.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<CategoryResponse> findResults(List<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category category: categories){
            categoryResponses.add(new CategoryResponse(category.getId(), category.getName()));
        }
        return categoryResponses;
    }
    public static CategoryResponse findResult (Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }
}
