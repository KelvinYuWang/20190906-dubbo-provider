package com.aaa.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ApplicationRun8081
 * @Author 王宇
 * @Date 2019/9/6 15:59
 * @Version 1.0
 *      使用的是springboot，springboot其实已经把很多歌框架以组件的形式集成进了自己（mybatis，redis...）
 *      springboot默认没有整合dubbo，dubbo就自己编写一套整合程序
 *      @EnableDubbo :在springboot程序中开启dubbo
 */
@SpringBootApplication
@MapperScan("com.aaa.dubbo.mapper")
@EnableDubbo
public class ApplicationRun8081 {
    public static void main(String[] args){
        SpringApplication.run(ApplicationRun8081.class,args);
    }
}

