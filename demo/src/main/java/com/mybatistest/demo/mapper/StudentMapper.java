package com.mybatistest.demo.mapper;

import com.mybatistest.demo.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {



    @Select("select * from student")
    List<Student> findAll();


    @Select("select * from student where id =#{id}")
    Student findByid(Integer id);

    @Update("update student set name=#{name},age=#{age},address=#{address} where id=#{id}")
    void update(Student student);

    @Delete("delete from  student where id=#{id} ")
    void delete(Integer id);
}
