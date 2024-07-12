package com.challange18.wit.dto;

import com.challange18.wit.entity.Author;
import com.challange18.wit.entity.Category;

public record BookResponse(long id, String name, Category category, Author author) {
}
