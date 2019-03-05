package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Mapper
public interface UserDao {
    List<User> selectUser();
    User getOne(Long id);
    @Transactional
    void insertUser(User s);
}
