package com.challange18.wit.service;

import com.challange18.wit.entity.Author;

public interface AuthorService {
    Author findById(long id);
    Author save(Author author);
}
