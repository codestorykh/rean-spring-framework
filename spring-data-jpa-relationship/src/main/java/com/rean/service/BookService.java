package com.rean.service;

import com.rean.dto.BookRequestDto;
import com.rean.dto.BookResponseDto;

import java.util.List;

public interface BookService {

    void createNewBook(BookRequestDto bookRequestDto) throws Exception;

    List<BookResponseDto> listBooks() throws Exception;

}
