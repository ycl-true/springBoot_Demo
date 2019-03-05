package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.enums.ResultEnums;
import com.example.demo.exception.UserException;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@ComponentScan({"com.example.demo.dao"})
@Service("userService")
public class UserService implements UserIService{
    @Resource
    private UserDao userDao;
    @Override
    public List<User> selectUser() {

        return userDao.selectUser();
    }
    @Override
    public User getOne(Long id){
        return getOne(id);
    }

    @Override
    public void insertUser(User u) {
        userDao.insertUser(u);
    }

    public void judgeId(Integer id) throws Exception {
        if(id < 22){
            throw new UserException(500, "小于22");
        } else if(id < 33){
            throw new UserException(600, "小于33");
        } else if(id < 44){
            throw new UserException(ResultEnums.ERROT_6);
        }else if(id <50){
            throw new Exception("错误");
        }
    }
    public String test(){
        return "1";
    }

}
