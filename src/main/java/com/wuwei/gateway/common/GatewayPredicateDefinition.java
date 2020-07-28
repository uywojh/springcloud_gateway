package com.wuwei.gateway.common;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: wuwei
 * @Date:2020-03-03 15:29
 * 路由断言模型
 */
@Data
public class GatewayPredicateDefinition {
    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
}
