package com.challange18.wit.controller;

import com.challange18.wit.dto.AuthorResponse;
import com.challange18.wit.dto.AuthorResponseWithBooks;
import com.challange18.wit.dto.BookResponse;
import com.challange18.wit.entity.Author;
import com.challange18.wit.entity.Book;
import com.challange18.wit.service.AuthorService;
import com.challange18.wit.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    private BookService bookService;
    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostMapping("/")
    public AuthorResponse save(@RequestBody Author author){
        authorService.save(author);
        return new AuthorResponse(author.getId(), author.getFirstName());
    }

    @PostMapping("/{bookId}")
    public AuthorResponseWithBooks save(@RequestBody Author author, @PathVariable long bookId){
        Book book = bookService.findById(bookId);
        author.addBook(book);
        book.setAuthor(author);
        authorService.save(author);

        // add this section to util package
        List<BookResponse> bookResponseList = new ArrayList<>();
        for(Book authorBook: author.getBookList()){
            bookResponseList.add(new BookResponse(authorBook.getId(), authorBook.getName(),
                    authorBook.getCategory().getName(),
                    new AuthorResponse(author.getId(),
                            author.getFirstName() + " " + author.getLastName())));
        }
        return new AuthorResponseWithBooks(bookResponseList);
    }
    //  Bu @PostMapping("/{bookId}") method ta bookId 'yi seçtiğim
    //  ama yazarı yeni ekliyorum ve yeni yazar idsi ile save liyor.

/*    "status": 500,
            "error": "Internal Server Error",
            "trace": "java.lang.NullPointerException: Cannot invoke \"com.challange18.wit.entity.Category.getName()\" because the return value of \"com.challange18.wit.entity.Book.getCategory()\" is null\n\tat com.challange18.wit.controller.
    Bu kodda hata almamam için önce book a bir kategory save lemem gerekiyor, orası boş dönünce NullPointer aldım.
    */
}
