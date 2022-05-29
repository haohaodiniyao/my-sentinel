package com.example.mysentinel.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    @GetMapping("hello")
    public String hello(){
        //使用限流规则
        try (Entry entry = SphU.entry("hello")) {


            return "hello sentinel";
        }catch (BlockException e){
            e.printStackTrace();
            return "系统繁忙，请稍后";
        }

    }
    //表示 当前类的构造函数执行之后执行
//    @PostConstruct
//    public void initFlowRules(){
//        //创建限流规则集合
//        List<FlowRule> rules = new ArrayList<>();
//        //创建限流规则
//        FlowRule rule = new FlowRule();
//        //资源,表示sentinel对哪些资源生效
//        rule.setResource("hello");
//        //定义限流规则类型FLOW_GRADE_QPS qps
//        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        //定义qps个数
//        rule.setCount(2);
//        //限流规则添加到集合
//        rules.add(rule);
//        //加载限流规则
//        FlowRuleManager.loadRules(rules);
//    }
}
