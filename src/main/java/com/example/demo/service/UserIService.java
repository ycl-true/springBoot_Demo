package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface  UserIService {
    List<User> selectUser();
    User getOne(Long id);
    void insertUser(User u);
}
