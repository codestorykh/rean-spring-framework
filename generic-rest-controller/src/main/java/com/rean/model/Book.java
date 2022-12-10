package com.rean.model;

import com.rean.generic.GenericEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbl_book")
public class Book implements Serializable, GenericEntity<Book> {

    private static final long serialVersionUID = 8953265385713562411L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publishedDate;
    private String description;
    private Integer categoryId;

    @Override
    public void update(Book source) {
        this.title = source.getTitle();
        this.author = source.getAuthor();
        this.publishedDate = source.getPublishedDate();
        this.description = source.getDescription();
        this.categoryId = source.getCategoryId();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public Book createNewInstance() {
        Book newBook = new Book();
        newBook.update(this);
        return newBook;
    }
}
