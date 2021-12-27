package com.example.todo2.service;

import com.example.todo2.entity.UserEntity;
import com.example.todo2.exceptions.UserAlreadyExist;
import com.example.todo2.exceptions.UserNotFound;
import com.example.todo2.model.User;
import com.example.todo2.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExist {
        if (userRepo.findByUsername(user.getUsername()) != null){
            throw new UserAlreadyExist("Пользователь с таким логином уже существует!");
        }
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFound{
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFound("Пользователь не найден!");
        }
        return User.toModel(user);
    }

    public Long deleteUser(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
