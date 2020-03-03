package com.wuwei.gateway.common;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wuwei
 * @Date:2020-03-03 15:29
 * 创建过滤器模型
 */
@Data
public class GatewayFilterDefinition {

    //Filter Name
    private String name;
    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();

}
