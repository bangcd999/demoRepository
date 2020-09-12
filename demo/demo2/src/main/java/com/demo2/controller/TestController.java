package com.demo2.controller;

import com.demo2.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {


    @GetMapping("/")
    String idx(@ModelAttribute Student student){
        student.setAge(18);
        student.setName("wei");
        return "index";
    }


}
