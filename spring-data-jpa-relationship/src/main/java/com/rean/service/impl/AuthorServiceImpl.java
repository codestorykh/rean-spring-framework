package com.rean.service.impl;

import com.rean.dto.AuthorRequestDto;
import com.rean.model.Author;
import com.rean.repository.AuthorRepository;
import com.rean.service.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;

    @Override
    public void add(AuthorRequestDto requestDto) throws Exception {
        Author author = authorRepository.save(modelMapper.map(requestDto, Author.class));
        if (Objects.isNull(author.getId())) {
            log.error("Saving new author was failed!");
            throw new Exception();
        }
    }

    @Override
    public Author findById(Long id) throws Exception {
        Optional<Author> author = authorRepository.findFirstById(id);
        return author.orElse(null);
    }
}
