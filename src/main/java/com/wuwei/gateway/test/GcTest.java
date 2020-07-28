package com.wuwei.gateway.test;

/**
 * @Author: wuwei
 * @Date:2020-03-19 12:44
 */
public class GcTest {
    public static void main(String[] args) {

        int _1m = 1024 * 1024;
        byte[] data = new byte[_1m];
        // 将data置为null即让它成为垃圾
        data = null;
        // 通知垃圾回收器回收垃圾
        System.gc();
    }
}