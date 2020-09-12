package com.mybatistest.demo.service;

import com.mybatistest.demo.domain.Student;
import com.mybatistest.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> findAll(){
        return studentMapper.findAll();
    }

    public Student findByid(Integer id) {
        return studentMapper.findByid(id);
    }

    public void update(Student student) {
        studentMapper.update(student);
    }

    public void delete(Integer id) {
        studentMapper.delete(id);
    }
}
