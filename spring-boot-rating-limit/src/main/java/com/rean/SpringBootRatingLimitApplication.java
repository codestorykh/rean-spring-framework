package com.rean;

import com.rean.model.Post;
import com.rean.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class SpringBootRatingLimitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRatingLimitApplication.class, args);
	}


	@Autowired
	PostRepository postRepository;

	@PostConstruct
	void initData() {
		List<Post> posts = Arrays.asList(
				new Post(0L, "Java", "Java Testing", new Date(), "Rean"),
				new Post(0L, "Spring Boot", "Spring Boot", new Date(), "Rean")
		);
		postRepository.saveAll(posts);
	}
}
