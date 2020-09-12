package com.mybatistest.demo.service;
import com.mybatistest.demo.domain.User;
import com.mybatistest.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User login(User user){
        return userMapper.login(user);
    }

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public int del(Integer id){
        return userMapper.del(id);
    }


}
