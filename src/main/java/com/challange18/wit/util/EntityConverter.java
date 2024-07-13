package com.challange18.wit.util;

import com.challange18.wit.dto.AuthorResponse;
import com.challange18.wit.dto.BookResponse;
import com.challange18.wit.dto.CategoryResponse;
import com.challange18.wit.entity.Author;
import com.challange18.wit.entity.Book;
import com.challange18.wit.entity.Category;


import java.util.ArrayList;
import java.util.List;

public class EntityConverter {
    public static List<CategoryResponse> findResults(List<Category> categories) {
        List<CategoryResponse> categoryResponses = new ArrayList<>();
        for(Category category: categories){
            categoryResponses.add(new CategoryResponse(category.getId(), category.getName()));
        }
        return categoryResponses;
    }
    public static CategoryResponse findResult (Category category){
        return new CategoryResponse(category.getId(), category.getName());
    }

    public static BookResponse findResultBook (Book book){
        return new BookResponse(book.getId(),
                book.getName(),
                book.getCategory().getName(),
                new AuthorResponse(book.getAuthor().getId(),book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName()));
    }
    // new AuthorResponse(author.getId(),
    //                   (author.getFirstName() + " " +author.getLastName())));
    // direkt author'dan çekmeyi kabul etmedi, anlamadım sebebini

    public static List<BookResponse> findResultBooks(List<Book> books) {
        List<BookResponse> bookResponses = new ArrayList<>();
        for(Book book: books){
            bookResponses.add(new BookResponse(book.getId(), book.getName(),book.getCategory().getName(),null));
            // authorName -> (book.getAuthor().getFirstName() + "  " + book.getAuthor().getLastName())
        }
        return bookResponses;
    }
}

// adım adım yazdığım için henüz author 'a bişey ekleyemiyorum. o yüzden NullPointerException hatası vermesin diye böyle yazdım.
