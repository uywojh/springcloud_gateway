package com.wuwei.gateway.test;

/**
 * @Author: wuwei
 * @Date:2020-03-19 13:41
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 对于计算密集型的任务，增加线程数并没有什么意义，线程数应该等于CPU内核数。如果较难把任务均摊到CPU，则
 * 可以把任务切分成较多块，以确保CPU完成某块任务后，可以继续处理其它块。防止某个CPU完成任务后处于空闲状态。
 *
 * @author shj
 */
public class ConcurrentPrimeFinder extends AbstractPrimeFinder {
    private final int poolSize;
    private final int numberOfParts;

    public ConcurrentPrimeFinder(int poolSize, int numberOfParts) {
        this.poolSize = poolSize;
        this.numberOfParts = numberOfParts;
    }

    @Override
    public int countPrimes(final int number) {
        int count = 0;
        try {
            List<Callable<Integer>> partitions = new ArrayList<>();
            int chunksPerPartition = number / numberOfParts;
            for (int i = 0; i < numberOfParts; i++) {
                final int lower = (i * chunksPerPartition) + 1;
                final int upper = (i == numberOfParts - 1) ? number : lower + chunksPerPartition - 1;
                partitions.add(new Callable<Integer>() {
                    @Override
                    public Integer call() {
                        return countPrimesInRange(lower, upper);
                    }
                });
            }

            ExecutorService executorPool = Executors.newFixedThreadPool(poolSize);
            List<Future<Integer>> results = executorPool.invokeAll(partitions, 10000, TimeUnit.SECONDS);
            executorPool.shutdown();

            for (Future<Integer> result : results) {
                count += result.get();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        int numberOfParts = 20; //划分成子区间的数量, 修改此值查看运行时间的变化
        new ConcurrentPrimeFinder(cores, numberOfParts).timeAndComputer(10_000_000);
    }
}
