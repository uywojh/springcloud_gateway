package com.wuwei.gateway.common;


/**
 * @author wuwei
 * @title: LimiterLevelResolver
 * @projectName ms
 * @description: TODO
 * @date 2019/7/1510:46
 */
public interface LimiterLevelResolver {

    default void save(RateLimiterLevel limiterLevel){}

    default RateLimiterLevel get(){
        return null;
    }
}
