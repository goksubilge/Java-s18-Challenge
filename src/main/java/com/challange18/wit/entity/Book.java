package com.challange18.wit.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="book", schema = "fsweb")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;
}
    // mappedBy olayını ManyToOne da yapmıyorum,
    // yalnızca cascade yapıyorum bu tanımı. Map lemeyi gidip
    // OneToOne kimdeyse o kısımda yapıyorum.
    // ama çift taraflı OneToOne ilişkilerde joinCloumn kimseyse
    // onun bağlantısına diğer tarafın instance ını yazıp map liyorum(belirtiyorum)

    // ManyToOne => default işlemi Detach, merge, refresh, persist 'tir.
    // Persist -> insertion
    // Merge  -> update
    // Refresh -> FindAll
    // Detach -> Get one thing

    // Kritik olan !! DELETE & UPDATE !!

