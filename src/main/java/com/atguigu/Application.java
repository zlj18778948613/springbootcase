package com.atguigu;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @作者: zhulinjia
 * @时间: 2022/10/11
 */
@SpringBootApplication
@EnableTransactionManagement //开启声明式事务
@MapperScan("com.atguigu.dao") //采用通用Mapper框架实现持久化层开发。导入tk.mybatis包
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
