package com.hongshu.controller;

import com.hongshu.model.Student;
import com.hongshu.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class StudentController
{
    @Resource
    private StudentService service;

    @RequestMapping("/addStudent")
    @ResponseBody
    public String addStudent(String name,Integer age)
    {
        Student s1 = new Student();
        s1.setName(name);
        s1.setAge(age);
        int rows = service.addStudent(s1);
        return "添加学生数量为"+rows+"信息："+s1;
    }
}
