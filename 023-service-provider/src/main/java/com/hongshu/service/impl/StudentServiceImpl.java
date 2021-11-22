package com.hongshu.service.impl;

import com.hongshu.model.Student;
import com.hongshu.service.StudentService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 使用dubbo中的注解暴露服务
 */
//@Component 可以不用加
@DubboService(interfaceClass = StudentService.class,version = "1.0",timeout = 5000)
public class StudentServiceImpl implements StudentService
{
    @Override
    public Student queryStudent(Integer id)
    {
        Student student = new Student();
        if(id == 1001)
        {
            student.setId(1001);
            student.setName("1001-张三");
            student.setAge(20);
        } else if(id == 1002)
        {
            student.setId(1002);
            student.setName("1002-李四");
            student.setAge(22);
        }
        return student;
    }
}
