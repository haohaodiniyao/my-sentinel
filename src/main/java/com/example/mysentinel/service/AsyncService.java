package com.example.mysentinel.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AsyncService {

    @Async
    public void hello(){
        log.info("异步调用开始");
        try{
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        log.info("完成异步调用");
    }
}
