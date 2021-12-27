package com.example.todo2.service;

import com.example.todo2.entity.TodoEntity;
import com.example.todo2.entity.UserEntity;
import com.example.todo2.exceptions.UserNotFound;
import com.example.todo2.model.Todo;
import com.example.todo2.repository.TodoRepo;
import com.example.todo2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId) throws UserNotFound{
        UserEntity user = userRepo.findById(userId).get();
        if (user == null){
            throw new UserNotFound("Пользователь не найден!");
        }
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo updateTodo(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));

    }
}
