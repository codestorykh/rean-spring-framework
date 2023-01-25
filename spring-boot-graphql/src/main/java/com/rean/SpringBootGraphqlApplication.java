package com.rean;

import com.rean.model.Author;
import com.rean.model.Book;
import com.rean.repository.AuthorRepository;
import com.rean.repository.BookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(AuthorRepository authorRepository, BookRepository bookRepository) {
		return args -> {
			Author author1 = Author.builder()
					.id(1L)
					.name("VidIQ")
					.build();
			authorRepository.save(author1);

			Author author2 = Author.builder()
					.id(2L)
					.name("Spring Developer")
					.build();
			authorRepository.save(author2);

			List<Book> books = Arrays.asList(
					new Book(1L, "Free AI Power Daily Video Ideas", "VidIQ", author1),
					new Book(2L, "Youtube Tutorial", "Youtube", author2)
			);
			bookRepository.saveAll(books);
		};
	}
}
