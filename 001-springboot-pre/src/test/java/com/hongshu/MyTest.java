package com.hongshu;

import com.hongshu.config.SpringConfig;
import com.hongshu.vo.Cat;
import com.hongshu.vo.Student;
import com.hongshu.vo.Tiger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest
{
    /**
     * 使用xml作为容器配置文件
     */
    @Test
    public void test01()
    {
        String config = "beans.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ac.getBean("myStudent");
        System.out.println("容器中的对象："+student);
    }

    /**
     * 使用JavaConfig
     */
    @Test
    public void test02(){
        ApplicationContext ac  = new AnnotationConfigApplicationContext(SpringConfig.class);
        Student s1 = (Student) ac.getBean("createStudent");
        Student s2 = (Student) ac.getBean("myStudent");
        System.out.println("使用JavaConfig创建的bean对象："+s1);
        System.out.println("使用JavaConfig创建的指定名称的bean对象："+s2);
    }

    @Test
    public void test03(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        Cat cat  = (Cat) ac.getBean("myCat");
        System.out.println("cat=="+cat);
    }

    @Test
    public void test04(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        Tiger tiger = (Tiger) ac.getBean("tiger");
        System.out.println("tiger=="+tiger);
    }
}
