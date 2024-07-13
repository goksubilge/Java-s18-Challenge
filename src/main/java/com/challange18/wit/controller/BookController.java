package com.challange18.wit.controller;

import com.challange18.wit.dto.BookResponse;
import com.challange18.wit.entity.Author;
import com.challange18.wit.entity.Book;
import com.challange18.wit.entity.Category;
import com.challange18.wit.service.AuthorService;
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
    private AuthorService authorService;
    @Autowired
    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
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

    @PostMapping("/saveByAuthor/{categoryId}/{authorId}")
    public BookResponse save(@RequestBody Book book, @PathVariable long categoryId, @PathVariable long authorId) {

        // Saving Category Bi-directional
        Category category = categoryService.findById(categoryId);
        book.setCategory(category);
        category.addBook(book);

        // Saving Author Bi-directional
        Author author = authorService.findById(authorId);
        book.setAuthor(author);
        author.addBook(book);

        return EntityConverter.findResultBook(bookService.saveC(book));
    }
}
