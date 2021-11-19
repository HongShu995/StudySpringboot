package com.hongshu.service.impl;

import com.hongshu.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService
{
    @Override
    public void sayHello(String name)
    {
        System.out.println("执行了业务方法sqyHello："+name);
    }
}
