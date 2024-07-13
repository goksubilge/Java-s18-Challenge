package com.challange18.wit.controller;

import com.challange18.wit.dto.AuthorResponse;
import com.challange18.wit.entity.Author;
import com.challange18.wit.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/")
    public AuthorResponse save(@RequestBody Author author){
        authorService.save(author);
        return new AuthorResponse(author.getId(), author.getFirstName(), author.getLastName());
    }
}
