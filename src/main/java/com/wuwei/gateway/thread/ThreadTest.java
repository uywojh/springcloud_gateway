package com.wuwei.gateway.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wuwei
 * @Date:2020-03-22 17:18
 */
public class ThreadTest {

    private static int nThreads = Runtime.getRuntime().availableProcessors()*2+1;
    private static ExecutorService executorService = Executors.newFixedThreadPool(nThreads, new ThreadFactory() {
        //创建线程池

        private final String threadNamePrefix = "thread_name+task_";

        private final AtomicInteger count = new AtomicInteger(1);//原子性操作,保证每个线程数值的安全性

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(Thread.currentThread().getThreadGroup(),r,threadNamePrefix+count.getAndIncrement());
            t.setDaemon(true);
            return t;
        }
    });



}
