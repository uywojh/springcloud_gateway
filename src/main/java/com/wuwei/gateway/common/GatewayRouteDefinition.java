package com.wuwei.gateway.common;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: wuwei
 * @Date:2020-03-03 15:28
 * 创建路由模型
 */
@Data
public class GatewayRouteDefinition {

    //路由的Id
    private String id = UUID.randomUUID().toString();

    //路由断言集合配置
    private List<GatewayPredicateDefinition> predicates = new ArrayList<>();

    //路由过滤器集合配置
    private List<GatewayFilterDefinition> filters = new ArrayList<>();

    //路由规则转发的目标uri
    private String uri;

    //路由执行的顺序
    private int order = 0;

}
