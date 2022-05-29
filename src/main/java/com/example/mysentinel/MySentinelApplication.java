package com.example.mysentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync//支持异步调用
@SpringBootApplication
public class MySentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(MySentinelApplication.class, args);
    }

}
