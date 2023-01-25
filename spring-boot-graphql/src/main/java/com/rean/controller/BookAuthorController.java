package com.rean.controller;

import com.rean.dto.BookRequest;
import com.rean.model.Author;
import com.rean.model.Book;
import com.rean.repository.AuthorRepository;
import com.rean.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
@RequiredArgsConstructor
public class BookAuthorController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    @MutationMapping
    public Book addBook(@Argument BookRequest bookInput) {
        log.info("Intercept create new book {}", bookInput);
        Author author = authorRepository.findById(bookInput.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author ID not found"));
        Book book = Book.builder()
                .title(bookInput.title())
                .publisher(bookInput.publisher())
                .author(author)
                .build();
        bookRepository.save(book);
        return book;
    }

    @MutationMapping
    public Book updateBook(@Argument BookRequest bookInput) {
        Author author = authorRepository.findById(bookInput.authorId())
                .orElseThrow(() -> new IllegalArgumentException("Author ID not found"));

        Book book = bookRepository.findById(bookInput.id())
                .orElseThrow(() -> new IllegalArgumentException("Book ID not found"));

        book.setAuthor(author);
        book.setPublisher(bookInput.publisher());
        book.setTitle(bookInput.title());
        return bookRepository.save(book);
    }

    @MutationMapping
    public Boolean deleteBook(@Argument Long id) {

        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Book id not found"));
        bookRepository.delete(book);
        return true;
    }

    @QueryMapping
    public Iterable<Author> authors() {
        log.info("Get all authors");
        return authorRepository.findAll();
    }

    @QueryMapping
    public Author authorById(@Argument Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Author ID not found"));
    }
}
