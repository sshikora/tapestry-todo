package com.example.todo.entities;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents a Todo item.
 */
public class Todo {

    private String id;
    private String title;
    private boolean completed;
    private LocalDateTime createdAt;

    public Todo() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    public Todo(String title) {
        this();
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void toggleCompleted() {
        this.completed = !this.completed;
    }
}
