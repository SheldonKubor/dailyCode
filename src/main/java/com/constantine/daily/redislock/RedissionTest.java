package com.constantine.daily.redislock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

public class RedissionTest {
    public static void main(String[] args) {
        RedissonClient redissonClient = Redisson.create();
        RLock lock = redissonClient.getLock("aaa");
        lock.lock(30, TimeUnit.SECONDS);
    }


}
