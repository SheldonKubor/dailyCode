package com.constantine.daily.concurrency.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
    AbstractQueuedSynchronizer abstractQueuedSynchronizer;
    ReentrantLock lock = new ReentrantLock();
}
