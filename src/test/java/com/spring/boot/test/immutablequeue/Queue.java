package com.spring.boot.test.immutablequeue;

public interface Queue<T> {

    public Queue<T> enqueue(T item);

    public Queue<T> dequeue();

    public T head();

    public int size();

    public boolean isEmpty();
}
