package com.challange18.wit.service;

import com.challange18.wit.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(long id);
    Book saveC(Book book);
    Book update(Book book);
    Book delete(long id);
}
