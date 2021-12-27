package com.example.todo2.model;

import com.example.todo2.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private Long id;
    private String username;
    private List<Todo> todos;

    public User(){

    }

    public static User toModel(UserEntity user){
        User model = new User();
        model.setId(user.getId());
        model.setUsername(user.getUsername());
        // преобразуем массив TodoEntity в массив Todo
        model.setTodos(user.getTodos().stream().map(Todo::toModel).collect(Collectors.toList()));

        return model;
    }

    public Long getId() {
        return id;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
