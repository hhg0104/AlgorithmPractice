package com.spring.boot.test.queue;

import java.util.Stack;

public class QueueWith2Stacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int data) {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        stack1.push(data);

        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public Integer dequeue() {
        if (stack1.isEmpty()) {
            return null;
        }

        return stack1.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
