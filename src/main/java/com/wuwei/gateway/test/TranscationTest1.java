package com.wuwei.gateway.test;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: wuwei
 * @Date:2020-03-22 17:04
 */
@Service
public class TranscationTest1 {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void method1(){
        System.out.println("method1");
    }
}
