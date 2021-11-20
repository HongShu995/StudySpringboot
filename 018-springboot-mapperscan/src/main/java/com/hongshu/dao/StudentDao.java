package com.hongshu.dao;

import com.hongshu.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Mapper：告诉MyBatis这是dao接口，创建此接口的代理对象。
 *     位置：在类的上面
 */
public interface StudentDao
{
    Student selectById(Integer id);

    List<Student> selectStudents();
}
