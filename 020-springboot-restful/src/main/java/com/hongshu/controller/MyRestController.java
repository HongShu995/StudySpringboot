package com.hongshu.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyRestController
{
    //学习注解的使用

    //查询id=1001的学生

    /**
     * @ PathVariable（路径变量） : 获取url中的数据
     *         属性： value ： 路径变量名
     *         位置： 放在控制器方法的形参前面
     *
     * http://localhost:8080/student/1002
     *
     * {stuId}:定义路径变量， stuId自定义名称
     */
    @GetMapping("/student/{stuId}")
    public String queryStudent(@PathVariable(value = "stuId")Integer stuId)
    {
        return "查询学生的id为："+stuId;
    }


    //请求方式和url一起要唯一
    //@GetMapping("/student/{age}")
    //public String queryStudentAge(@PathVariable(value = "age")Integer age)
    //{
    //    return "查询学生的年龄为："+age;
    //}

    /***
     * 创建资源 Post请求方式
     * http://localhost:8080/student/zhangsan/20
     */
    @PostMapping("/student/{name}/{age}")
    public String createStudent(@PathVariable("name")String name,
                                @PathVariable("age")Integer age)
    {
        return "学生姓名为："+name+" 年龄为："+age;
    }

    /**
     * 更新资源
     *
     * 当路径变量名称和 形参名一样， @PathVariable中的value可以省略
     */
    @PutMapping("/student/{id}/{age}")
    public String modifyStudent(@PathVariable Integer id,
                                @PathVariable Integer age){
        return "更新资源， 执行put请求方式： id="+id+"#age="+age;

    }

    /**
     * 删除资源
     */
    @DeleteMapping("/student/{id}")
    public String removeStudentById(@PathVariable Integer id){
        return "删除资源，执行delete， id="+id;
    }

    @PutMapping("/student/test")
    public String test()
    {
        return "执行student/test，使用请求方式为put";
    }
}
