package com.wuwei.gateway.common;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wuwei
 * @title: RateLimiterConfig
 * @projectName demo1
 * @description: TODO 限流等级配置
 * @date 2019/7/515:26
 */
@Data
public class RateLimiterLevel implements Serializable {
    private List<RateLimiterVO> levels;
}
