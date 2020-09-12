package com.mybatistest.demo.contoller;
import com.mybatistest.demo.domain.Student;
import com.mybatistest.demo.domain.User;
import com.mybatistest.demo.service.StudentService;
import com.mybatistest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@SessionAttributes(names = {"errMsg", "userLogin","stuList"})
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;



    @GetMapping({"/hello", "/"})
    String login() {
        return "login";
    }


    @PostMapping("user/login")
    String login_(User user, Model model) {
        User loginUser = userService.login(user);
        if (loginUser == null) {
            model.addAttribute("errMsg", "用户名或密码错误");
            return "redirect:/login.html"; //这里的login.html在配置中被映射过
        }
        List<Student> stuList = studentService.findAll();
        model.addAttribute("userLogin", loginUser );
        model.addAttribute("stuList", stuList );
        return "redirect:/index.html";
    }

    @GetMapping("user")
    @ResponseBody
    List<User> user(){
      return  userService.findAll();
    }

    @DeleteMapping("del")
    @ResponseBody
    String del(Integer id,Model model){
        studentService.delete(id);
        model.addAttribute("stuList", studentService.findAll());
        return "ok";
    }


    @GetMapping("update/{id}")
    String update(@PathVariable("id")Integer id,Model model){
        Student student= studentService.findByid(id);
        model.addAttribute("stu",student);
        return "update";
    }

    @PostMapping("updates")
    String up(Student student,Model model){
        studentService.update(student);
        model.addAttribute("stuList", studentService.findAll());
        return "redirect:/index.html";
    }


//-----------------------------------------------------

    @GetMapping("other")
    String other(Model model){
        List<Student> all = studentService.findAll();
        Map<String, Student> studMap = all.stream().collect(Collectors.toMap(Student::getName,student -> student));
        model.addAttribute("studMap",studMap);
        return "other";
    }

    @GetMapping("page")
    String  page(
            @RequestParam(value = "currPage",defaultValue = "1")Integer currPage,
            @RequestParam(value = "rows",defaultValue = "3")Integer rows,
            Map<String,Object> map
    ){
//        studentService.page(currPage,rows,map)

        return "page";
    }
}
