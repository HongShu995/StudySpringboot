package com.hongshu.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RedisController
{
    /**
     * 注入RedisTemplate
     *
     * RedisTemplate 泛型
     * RedisTemplate<String,String>
     * RedisTemplate<Object,Object>
     * RedisTemplate
     *
     * 注意： RedisTemplate对象的名称 redisTemplate
     */

    @Resource
    private RedisTemplate redisTemplate;

    //添加数据到redis
    @RequestMapping
    public String addToRedis(String name,String value)
    {
        return "向redis添加String数据";
    }


    //从redis获取数据
}
