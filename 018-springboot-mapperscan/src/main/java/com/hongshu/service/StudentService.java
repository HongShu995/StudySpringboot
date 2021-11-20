package com.hongshu.service;

import com.hongshu.entity.Student;

import java.util.List;

public interface StudentService
{
    Student queryStudent(Integer id);

    List<Student> findAllStudent();
}
