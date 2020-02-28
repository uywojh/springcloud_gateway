package com.wuwei.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * @Author: wuwei
 * @Date:2020-02-28 22:31
 */
public class Config {

    @Bean
    KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }


    @Bean
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

    @Bean
    public KeyResolver UriKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getURI().getPath());
    }


}
