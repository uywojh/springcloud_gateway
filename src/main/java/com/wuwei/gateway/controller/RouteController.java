package com.wuwei.gateway.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wuwei
 * @Date:2020-03-03 15:32
 * 编写 Rest接口，通过这些接口实现动态路由功能，注意SpringCloudGateway使用的是WebFlux不要引用WebMvc
 */
public class RouteController {


    private static volatile Map<Integer, AtomicInteger> jobTimeoutCountMap = new ConcurrentHashMap<>();

    public void restTest(){
        System.out.println("hs");
    }
    public static void main(String[] args) {



    }
}
