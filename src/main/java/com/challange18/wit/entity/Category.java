package com.challange18.wit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="category", schema = "fsweb")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL})
    private List<Book> bookList;
    // = new ArrayList<>();

    public void addBook (Book book){
        if (bookList == null){
            bookList = new ArrayList<>();
        }
        bookList.add(book);
    }

    // OneToMany 'nin Default cascade 'i => CascadeType.ALL
}
