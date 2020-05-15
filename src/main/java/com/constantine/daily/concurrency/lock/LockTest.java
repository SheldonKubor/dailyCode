package com.constantine.daily.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *          synchronized              |           lock
 *    java关键字，jvm层面               |         是一个类
 *
 *    1.获取锁线程执行完会自动释放锁      |       1. 手动释放锁
 *    2.线程异常会释放锁                 |      2. 在finally中释放锁，避免死锁
 *
 *    A线程获得锁，B等待。假如A阻塞，      |         多种获得锁的方式
 *    B会一直等待                        |         B不用一直等待
 *
 *    锁状态无法判断                      |        锁状态可以判断
 *
 *    可重入，不可判断，非公平              |       可重入，可判断，可公平
 *
 *    少量同步                             |      大量同步
 */
public class LockTest {

    private Lock lock = new ReentrantLock();
    //需要参与同步的方法
    private void method(Thread thread){
//        //lock方法
//        lock.lock();
//        try {
//            System.out.println("线程名"+thread.getName() + "获得了锁");
//        }catch(Exception e){
//            e.printStackTrace();
//        } finally {
//            System.out.println("线程名"+thread.getName() + "释放了锁");
//            lock.unlock();
//        }


        //trylock方法
        if(lock.tryLock()){
            try {
                System.out.println("线程名"+thread.getName() + "获得了锁");
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("线程名"+thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("我是"+Thread.currentThread().getName()+"有人占着锁，我就不要啦");
        }
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();

        //线程1
        Thread t1 = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockTest.method(Thread.currentThread());
            }
        }, "t1");

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
