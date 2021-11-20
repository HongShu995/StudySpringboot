package com.hongshu.service.impl;

import com.hongshu.dao.StudentDao;
import com.hongshu.entity.Student;
import com.hongshu.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    @Resource
    private StudentDao studentDao;

    @Override
    public Student queryStudent(Integer id)
    {
        return studentDao.selectById(id);
    }

    @Override
    public List<Student> findAllStudent()
    {
        return studentDao.selectStudents();
    }
}
