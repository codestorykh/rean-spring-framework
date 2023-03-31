package com.rean.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Todo {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean completed;

    public Todo() {
        this.created = LocalDateTime.now();
        this.modified = LocalDateTime.now();
    }

    public Todo(Long id, String title, String description) {
        this();
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
