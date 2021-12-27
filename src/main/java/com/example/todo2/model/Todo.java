package com.example.todo2.model;

import com.example.todo2.entity.TodoEntity;

public class Todo {

    private Long id;
    private String title;
    private Boolean completed;

    public static Todo toModel(TodoEntity todo){
        Todo model = new Todo();
        model.setId(todo.getId());
        model.setTitle(todo.getTitle());
        model.setCompleted(todo.getCompleted());

        return model;
    }

    public Todo() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getCompleted() {
        return completed;
    }
}
