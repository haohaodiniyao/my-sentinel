package com.example.mysentinel.controller;

import com.alibaba.csp.sentinel.SphO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestBooleanController {
    @GetMapping("boolean")
    public boolean hello(){
        if (SphO.entry("Sentinel_Boolean")) {//限流入口
            try{
                //被保护的资源
                System.out.println("访问成功");
                return true;
            }finally {
//                和SphO.entry成对出现
                SphO.exit();//限流出口
            }
        }else{
            //被限流或降级的处理
            System.out.println("系统繁忙，请稍后");
            return false;
        }
    }
}
