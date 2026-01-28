package com.example.todo.services;

import com.example.todo.entities.Todo;

import java.util.List;

/**
 * Service interface for managing Todo items.
 */
public interface TodoService {

    /**
     * Get all todos.
     */
    List<Todo> getAllTodos();

    /**
     * Add a new todo.
     */
    void addTodo(String title);

    /**
     * Toggle the completed status of a todo.
     */
    void toggleTodo(String id);

    /**
     * Delete a todo by id.
     */
    void deleteTodo(String id);

    /**
     * Get the count of completed todos.
     */
    int getCompletedCount();

    /**
     * Get the count of pending todos.
     */
    int getPendingCount();

    /**
     * Clear all completed todos.
     */
    void clearCompleted();
}
