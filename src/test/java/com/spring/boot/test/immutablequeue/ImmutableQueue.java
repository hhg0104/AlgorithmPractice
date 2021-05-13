package com.spring.boot.test.immutablequeue;

import java.util.Iterator;
import java.util.List;

public class ImmutableQueue<T> implements Queue<T>{

    private int size = 0;

    private Node head, tail;

    private class Node {
        T item;
        Node next = null;
        Node(T item) {
            this.item = item;
        }
    }

    public ImmutableQueue() {
    }

    public ImmutableQueue(List<T> items) {
        this();

        if (items == null) {
            return;
        }

        items.stream().forEach(item -> {
            enqueue(item);
        });
    }

    @Override
    public Queue<T> enqueue(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }

        size += 1;

        Node oldTail = tail;
        Node newTail = new Node(item);
        if (isEmpty()) {
            head = newTail;
            return this;
        }

        oldTail.next = newTail;

        return this;
    }

    @Override
    public Queue<T> dequeue() {
        Node currentHead = head;
        if (isEmpty()) {
            throw new NullPointerException("There is no item anymore.");
        }

        size -= 1;
        head = currentHead.next;

        return this;
    }

    @Override
    public T head() {
        if (isEmpty()) {
           return null;
        }
        return head.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T currentItem = current.item;
                current = current.next;
                return currentItem;
            }
        };
    }
}
