package com.constantine.daily.concurrency.myunsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    //static final Unsafe unsafe = Unsafe.getUnsafe();
    static Unsafe unsafe;

    static long stateOffset;

    private volatile long state = 0;

    static {

        try {

            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("state"));
        } catch (Exception ex){
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {
        TestUnsafe testUnsafe = new TestUnsafe();
        boolean success = unsafe.compareAndSwapInt(testUnsafe,stateOffset,0,1);
        System.out.println(success);
    }

}
