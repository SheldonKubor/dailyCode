package com.constantine.daily.concurrency.threadlocal;

public class Val<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
