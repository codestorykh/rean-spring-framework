package com.rean.dto;

import lombok.Data;

@Data
public class BookRequest {

    private Long id;
    private String title;
    private String publisher;
    private Long authorId;
}
