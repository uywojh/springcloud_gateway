package com.wuwei.gateway.utils;

import java.lang.annotation.*;

/**
 * @Author: wuwei
 * @Date:2020-03-25 10:31
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtCheck {
    String value() default "";
}
