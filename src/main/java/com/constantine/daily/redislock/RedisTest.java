package com.constantine.daily.redislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;

public class RedisTest {

    private static Integer inventory = 101;
    private static final int NUM = 100;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(inventory, inventory, 10L, SECONDS, linkedBlockingQueue);
        long start = System.currentTimeMillis();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        final RedissonClient client = Redisson.create(config);
        //final RLock lock = client.getLock("lock1");
        final RedisLock lock = new RedisLock();
        for (int i = 0; i <= NUM; i++) {
            threadPoolExecutor.execute(new Runnable() {
                public void run() {
                    lock.lock("aaa");
                    inventory--;
                    System.out.println(inventory);
                    lock.unlock("aaa");
                }
            });
        }
        long end = System.currentTimeMillis();
        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);
    }


}
