package com.example.todo2.controller;

import com.example.todo2.entity.TodoEntity;
import com.example.todo2.exceptions.UserNotFound;
import com.example.todo2.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping
    public ResponseEntity createTodo(@RequestBody TodoEntity todo, @RequestParam Long id){

        try{
            return ResponseEntity.ok(todoService.createTodo(todo, id));
        } catch (UserNotFound e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }

    }

    @PutMapping
    public ResponseEntity updateTodo(@RequestParam Long id){
        try{
            return ResponseEntity.ok(todoService.updateTodo(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
