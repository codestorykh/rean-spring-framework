package com.rean.service;

import com.rean.model.Post;
import com.rean.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> posts() {
        return postRepository.findAll();
    }
}
