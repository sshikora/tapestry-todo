package com.example.todo.pages;

import com.example.todo.entities.Todo;
import com.example.todo.services.TodoService;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ajax.AjaxResponseRenderer;

import java.util.List;

/**
 * Main page for the Todo application.
 */
public class Index {

    @Inject
    private TodoService todoService;

    @Inject
    private AjaxResponseRenderer ajaxResponseRenderer;

    @InjectComponent
    private Zone todoZone;

    @InjectComponent
    private Form addForm;

    @Property
    @Persist
    private String newTodoTitle;

    @Property
    private Todo currentTodo;

    public List<Todo> getTodos() {
        return todoService.getAllTodos();
    }

    public int getCompletedCount() {
        return todoService.getCompletedCount();
    }

    public int getPendingCount() {
        return todoService.getPendingCount();
    }

    public int getTotalCount() {
        return getTodos().size();
    }

    public boolean hasTodos() {
        return !getTodos().isEmpty();
    }

    public boolean hasCompletedTodos() {
        return getCompletedCount() > 0;
    }

    public String getTodoItemClass() {
        return currentTodo.isCompleted() ? "completed-text" : "";
    }

    public String getCheckboxClass() {
        return currentTodo.isCompleted()
            ? "bg-green-500 border-green-500"
            : "border-gray-300";
    }

    void onSuccessFromAddForm() {
        if (newTodoTitle != null && !newTodoTitle.trim().isEmpty()) {
            todoService.addTodo(newTodoTitle);
            newTodoTitle = null;
        }
    }

    void onActionFromToggle(String id) {
        todoService.toggleTodo(id);
    }

    void onActionFromDelete(String id) {
        todoService.deleteTodo(id);
    }

    void onActionFromClearCompleted() {
        todoService.clearCompleted();
    }
}
