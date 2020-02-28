package com.wuwei.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: wuwei
 * @Date:2020-02-28 22:53
 * 默认降级处理
 */
@RestController
@RequestMapping("/fallback")
public class DefaultHystrixController {

    @RequestMapping("")
    public Map<String,String> fallback(){
        System.out.println("降级操作...");
        Map<String,String> map = new HashMap<>();
        map.put("resultCode","fail");
        map.put("resultMessage","服务异常");
        map.put("resultObj","null");
        return map;
    }

}
