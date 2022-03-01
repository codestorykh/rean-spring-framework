package com.springdatajpa;

import com.springdatajpa.model.Book;
import com.springdatajpa.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    void saveBooks() {
        List<Book> books = Arrays.asList(
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book1", "Mr A", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date()),
                new Book(0L, "Hero Book2", "Mr B", 29.00, new Date())
        );
        bookRepository.saveAll(books);


    }

    @Bean
    void demoDerivedQuery() {
        this.saveBooks();
        List<Book> books = bookRepository.findAllByAuthor("Mr B");
    }

}