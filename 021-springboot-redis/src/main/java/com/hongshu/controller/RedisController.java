package com.hongshu.controller;

import com.hongshu.vo.Student;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //添加数据到redis
    @PostMapping("/redis/addString")
    public String addToRedis(String name,String value)
    {
        //操作redis中String类型的数据，先获取ValueOperations对象
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("myname","lisi");
        return "向redis添加String数据";
    }


    //从redis获取数据
    @GetMapping("/redis/getk")
    public String getData(String k)
    {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        return "Key是："+k+",Value是："+v;
    }

    @PostMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable("k")String k,
                              @PathVariable("v")String v)
    {
        // 使用StringRedisTemplate对象
        stringRedisTemplate.opsForValue().set(k,v);
        return "使用的是StringRedisTemplate对象";
    }

    @GetMapping("/redis/getstr/{k}")
    public String addStringV(@PathVariable("k")String k)
    {
        // 使用StringRedisTemplate对象
        String v = stringRedisTemplate.opsForValue().get(k);
        return "K的Value: "+v;
    }

    /**设置RedisTemplate的序列化机制
     * 可以设置 key 的序列化， 可以设置value的序列化
     * 可以同时设置 key 和 value的序列化
     */

    @PostMapping("/redis/addstr")
    public String addString(String k,String v)
    {
        //使用redisTemplate
        //设置key的序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置value的序列化
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(k,v);
        return "定义了RedisTemplate的key与value序列化";
    }

    /**
     * 使用json 序列化， 把java对象转为json存储
     */

    @PostMapping("/redis/addjson")
    public String addJson()
    {
        Student student = new Student();
        student.setId(1001);
        student.setName("zhangsan");
        student.setAge(20);

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        redisTemplate.opsForValue().set("mystudent",student);
        return "json的序列化";
    }

    @GetMapping("/redis/getjson")
    public String getJson()
    {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(Student.class));
        Object obj = redisTemplate.opsForValue().get("mystudent");
        return "json的反序列化="+obj;
    }
}
