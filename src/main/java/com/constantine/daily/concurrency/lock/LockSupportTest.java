package com.constantine.daily.concurrency.lock;

import javax.sound.midi.Soundbank;
import java.util.concurrent.locks.LockSupport;

public class LockSupportTest {

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("begin park");
//        LockSupport.unpark(Thread.currentThread());
//        LockSupport.park();
//        System.out.println("end park");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread begin park");
                LockSupport.park();
                System.out.println("child thread end park");
            }
        });

        thread.start();
        Thread.sleep(1000);
        System.out.println("main thread begin unpark");
        LockSupport.unpark(thread);
    }
}
