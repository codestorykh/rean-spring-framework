package com.rean.service;

import com.rean.dto.AuthorRequestDto;
import com.rean.model.Author;

public interface AuthorService {

    void add(AuthorRequestDto authorRequestDto) throws Exception;

    Author findById(Long id) throws Exception;
}
