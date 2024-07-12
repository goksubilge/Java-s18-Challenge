package com.challange18.wit.service;

import com.challange18.wit.entity.Book;
import com.challange18.wit.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }
        // GlobalHandling
        throw new RuntimeException("Book with given id is not exist: " + id );
    }

    @Override
    public Book saveC(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book saveCA(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public Book delete(long id) {
        return null;
    }
}
