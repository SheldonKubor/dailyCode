package com.constantine.daily.concurrency.threadlocal;

public class Basic {

    public static ThreadLocal<Long> x = new ThreadLocal(){

        @Override
        protected Long initialValue(){
            System.out.println("init value");
            //return 100l;

            //改为返回当前线程id
            return Thread.currentThread().getId();
        }
    };

    public static void main(String[] args) {

        /**
         * 1. 执行两次get，initialValue只会执行一次，属于初始化的一个过程
         * 2. initialValue会在get之前触发
         * 3. 不执行get方法，initialValue不会触发，因为延迟加载
         * 4. set方法可以手工设置值，使用set设置值之后，就不会触发initialValue
         */
        //x.set(101l);
        //System.out.println(x.get());
        //System.out.println(x.get());

        /**
         * 实验两个线程main与新建线程，threadlocal的情况
         * initialValue只会执行两次，每个线程都会有一个x变量
         */
        new Thread(){
            @Override
            public void run() {
                System.out.println(x.get());
            }
        }.start();

        /**
         * remove之后为何打印不是空呢，因为remove的是set的111l，打印的时候调用get方法，发现x为空，就会触发initialValue方法
         */
        x.set(111l);
        x.remove();
        System.out.println(x.get());

    }
}
