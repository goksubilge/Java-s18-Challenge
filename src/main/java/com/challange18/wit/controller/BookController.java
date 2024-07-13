package com.challange18.wit.controller;

import com.challange18.wit.dto.BookResponse;
import com.challange18.wit.entity.Book;
import com.challange18.wit.entity.Category;
import com.challange18.wit.service.BookService;
import com.challange18.wit.service.CategoryService;
import com.challange18.wit.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    private BookService bookService;
    private CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService, CategoryService categoryService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
    }

/*    @PostMapping("/")
    public BookResponse save(@RequestBody Book book) {
        return EntityConverter.findResultBook(bookService.saveC(book));
   }*/
    @PostMapping("/{categoryId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId){
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);
        return EntityConverter.findResultBook(bookService.saveC(book));
        /*
        EntityConverter a çevirdim.
        bookService.saveC(book);
        return new BookResponse(book.getId(), book.getName(), book.getCategory().getName(),null);*/
    }
}
