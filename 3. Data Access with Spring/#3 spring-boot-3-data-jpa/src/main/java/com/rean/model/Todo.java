package com.rean.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tbl_todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;
    private LocalDateTime modified;
    private boolean completed;

    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @PrePersist // before any persistent action is taken
    public void onCreate() {
        this.setCreated(LocalDateTime.now());
        this.setModified(LocalDateTime.now());
    }

    @PreUpdate  // before any update action is taken
    public void onUpdate(){
        this.setModified(LocalDateTime.now());
    }

}
