package com.challange18.wit.controller;

import com.challange18.wit.dto.BookResponse;
import com.challange18.wit.entity.Book;
import com.challange18.wit.service.BookService;
import com.challange18.wit.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


}
