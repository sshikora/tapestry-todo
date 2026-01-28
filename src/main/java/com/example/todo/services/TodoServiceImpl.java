package com.example.todo.services;

import com.example.todo.entities.Todo;
import org.apache.tapestry5.ioc.annotations.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * In-memory implementation of TodoService.
 * Uses application scope to persist todos across requests.
 */
@Scope("singleton")
public class TodoServiceImpl implements TodoService {

    private final List<Todo> todos = new CopyOnWriteArrayList<>();

    public TodoServiceImpl() {
        // Add some sample todos
        addTodo("Learn Apache Tapestry");
        addTodo("Style with Tailwind CSS");
        addTodo("Build awesome applications");
    }

    @Override
    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos);
    }

    @Override
    public void addTodo(String title) {
        if (title != null && !title.trim().isEmpty()) {
            todos.add(new Todo(title.trim()));
        }
    }

    @Override
    public void toggleTodo(String id) {
        todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .ifPresent(Todo::toggleCompleted);
    }

    @Override
    public void deleteTodo(String id) {
        todos.removeIf(todo -> todo.getId().equals(id));
    }

    @Override
    public int getCompletedCount() {
        return (int) todos.stream().filter(Todo::isCompleted).count();
    }

    @Override
    public int getPendingCount() {
        return (int) todos.stream().filter(todo -> !todo.isCompleted()).count();
    }

    @Override
    public void clearCompleted() {
        todos.removeIf(Todo::isCompleted);
    }
}
