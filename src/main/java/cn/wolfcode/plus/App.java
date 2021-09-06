package cn.wolfcode.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Ahan
 * @version 1.0
 * @Date 2021/9/5
 * @description
 **/
@SpringBootApplication
@MapperScan(basePackages = "cn.wolfcode.plus.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
