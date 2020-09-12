package com.mybatistest.demo.mapper;
import com.mybatistest.demo.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;


import java.util.List;

public interface UserMapper {


    @Select("select * from user where name= #{name} and pwd= #{pwd}")
    User login(User user);

    @Select("select * from  user")
    List<User> findAll();

    @Delete("delete from user where id =#{id}")
    int del(Integer id);
}
