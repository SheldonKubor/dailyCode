package com.constantine.daily.concurrency.atomicobj;

import java.util.concurrent.atomic.AtomicInteger;

public class VoiatileTest {

    public static void main(String[] args) {
        VoiatileTestRunable myRunable = new VoiatileTestRunable();

        new Thread(myRunable,"t1").start();
        new Thread(myRunable,"t2").start();

    }
}
class VoiatileTestRunable implements Runnable{

    public static volatile AtomicInteger count = new AtomicInteger(5);

    @Override
    public void run() {

        int cnt;

        while((cnt =count.getAndDecrement())>0){
            try {
                Thread.sleep(500);
                //sale();
//                count.getAndDecrement();
                System.out.println(Thread.currentThread().getName() + ",出售第" + ((5 - cnt)+1) + "张票");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void sale() {

        if (count.get() > 0) {
            count.getAndDecrement();
            System.out.println(Thread.currentThread().getName() + ",出售第" + (5 - count.get()) + "张票");
        }

    }
}