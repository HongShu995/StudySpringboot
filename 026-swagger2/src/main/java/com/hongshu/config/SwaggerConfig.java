package com.hongshu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig
{


    //配置Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment)
    {
        //获取项目的环境
        Profiles profiles = Profiles.of("dev");
        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                //是否启动
                .enable(flag)
                .apiInfo(apiInfo())
                .select()
                //配置扫描接口的方式RequestHandlerSelectors
                //basePackage指定扫描的包
                //any扫描全部
                //none都不扫描
                //withClassAnnotation扫描类上的指定注解的类
                //withMethodAnnotation扫描方法上的指定注解的类
                .apis(RequestHandlerSelectors.basePackage("com.hongshu.controller"))
                //过滤什么路径请求的类
                //.paths(PathSelectors.any())
                .build();
    }

    //配置Swagger信息=apiInfo
    private ApiInfo apiInfo()
    {
        //作者信息
        Contact contact = new Contact("Hong_Shu995","http://loaclhost:8080/xxxxx","xxxxx@xxx.com");

        return new ApiInfo(
                "SwaggerApi文档标题",
                "Api文档描述",
                "v1.0",
                "http://loaclhost:8080",   //服务条款网址
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
