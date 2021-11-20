package com.hongshu.controller;

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

    @ResponseBody
    @RequestMapping("/student/query")
    public String queryStudent(Integer id)
    {
        return service.queryStudent(id).toString();
    }

    @ResponseBody
    @RequestMapping("/student/all")
    public String findAllStudent()
    {
        return service.findAllStudent().toString();
    }
}
