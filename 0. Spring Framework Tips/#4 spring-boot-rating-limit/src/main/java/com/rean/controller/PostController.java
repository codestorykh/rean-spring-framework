package com.rean.controller;

import com.rean.service.PostService;
import com.rean.service.RatingLimitService;
import io.github.bucket4j.Bucket;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/posts")
public class PostController {

    private final PostService postService;
    private final RatingLimitService ratingLimitService;

    @Value("${user.type}")
    private String userType;

    private Bucket bucket;
    @PostConstruct
    public Bucket bucket() {
        bucket = ratingLimitService.bucket(userType);
        return bucket;
    }

    public PostController(PostService postService, RatingLimitService ratingLimitService) {
        this.postService = postService;
        this.ratingLimitService = ratingLimitService;
    }

    @GetMapping
    public ResponseEntity<Object> posts(){
        if(bucket.tryConsume(1)) {
            log.info("Intercept get all posts");
            return ResponseEntity.ok(postService.posts());
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }
}
