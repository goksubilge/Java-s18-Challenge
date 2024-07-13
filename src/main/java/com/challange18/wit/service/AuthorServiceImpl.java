package com.challange18.wit.service;

import com.challange18.wit.entity.Author;
import com.challange18.wit.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService{

    private AuthorRepository authorRepository;
    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findById(long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if(authorOptional.isPresent()){
            return authorOptional.get();
        }
        // GlobalHandling
        throw new RuntimeException("Author with given id is not exist:" + id);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
