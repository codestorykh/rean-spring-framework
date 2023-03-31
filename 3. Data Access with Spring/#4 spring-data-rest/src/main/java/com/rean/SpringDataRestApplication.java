package com.rean;

import com.rean.model.Book;
import com.rean.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@PostConstruct
	void initBooks() {

		List<Book> books = Arrays.asList(
				new Book(0L, "Spring Boot", "Spring DEV", "Spring Boot for beginner", 1, "12-3-2022"),
				new Book(0L, "Spring Data JPA", "Spring DEV", "Spring Data JPA for beginner", 1, "12-4-2022"),
				new Book(0L, "Spring Data REST", "Spring DEV", "Spring Data REST for beginner", 1, "11-3-2022"),
				new Book(0L, "Java", "Java DEV", "Java programming for beginner", 1, "12-11-2022")
		);

		bookRepository.saveAll(books);
	}
}
