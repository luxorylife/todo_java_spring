package com.example.todo2.exceptions;

public class UserAlreadyExist extends Exception{

    public UserAlreadyExist(String message) {
        super(message);
    }
}
