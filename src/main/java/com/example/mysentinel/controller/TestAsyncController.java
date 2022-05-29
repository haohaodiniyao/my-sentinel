package com.example.mysentinel.controller;

import com.alibaba.csp.sentinel.AsyncEntry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.example.mysentinel.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class TestAsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping("async")
    public void hello(){
        AsyncEntry asyncEntry = null;
        try{
            asyncEntry = SphU.asyncEntry("sentinel_async");//限流入口
            asyncService.hello();//调用异步方法(资源)
        }catch (BlockException e){
            log.info("系统繁忙，请稍后");
        }finally {
            if(asyncEntry != null){
                asyncEntry.exit();//限流出口
            }
        }
    }
}
