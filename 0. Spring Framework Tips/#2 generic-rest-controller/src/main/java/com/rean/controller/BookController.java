package com.rean.controller;

import com.rean.generic.GenericController;
import com.rean.model.Book;
import com.rean.repository.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController extends GenericController<Book> {

    protected BookController(BookRepository bookRepository) {
        super(bookRepository);
    }
}
