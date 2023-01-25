package com.rean.dto;

public record BookRequest(Long id, String title, String publisher, Long authorId) {
}
