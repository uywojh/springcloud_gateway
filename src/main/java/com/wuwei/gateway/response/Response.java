package com.wuwei.gateway.response;

import lombok.Data;

/**
 * @Author: wuwei
 * @Date:2020-02-28 19:37
 * 自定义响应内容
 */
@Data
public class Response {

    private String code;

    private String message;

    private String data;
}
