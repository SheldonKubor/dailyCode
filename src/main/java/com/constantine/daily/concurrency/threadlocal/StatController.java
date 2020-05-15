package com.constantine.daily.concurrency.threadlocal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.concurrent.ConcurrentSkipListSet;

@RestController
public class StatController {

//    static  Integer c = 0
    static HashSet<Val<Integer>> set = new HashSet<>();
    static ConcurrentSkipListSet<Val<Integer>> set2 = new ConcurrentSkipListSet<>();

    synchronized static void addSet(Val<Integer> val){
        set.add(val);
    }

    static ThreadLocal<Val<Integer>> c = new ThreadLocal(){

        @Override
        protected Val<Integer> initialValue(){
            Val<Integer> val = new Val<>();
            val.setValue(0);
            addSet(val);
            return val;
        }
    };
//相当于重写initialvalue方法


    /**
     * 1. 不加锁，并发请求add方法，c的值会与预期值不一样
     * 2. 加锁速度会很慢
     * 3. 将变量设置为threadlocal，会分散线程操作，需要把每个线程的操作收集起来。
     * @throws InterruptedException
     */
    /*synchronized*/ void cadd() throws InterruptedException {
        Thread.sleep(100l);
        //c++;
        Val<Integer> v = c.get();
        v.setValue(v.getValue()+1);
    }

    @GetMapping("/stat")
    public Integer stat(){
        return set.stream().map(x -> x.getValue()).reduce((a,x)->a+x).get();
    }

    @GetMapping("/add")
    public Integer add() throws InterruptedException {
        cadd();
        return 1;
    }
}
