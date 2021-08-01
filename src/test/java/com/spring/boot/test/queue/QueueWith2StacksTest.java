package com.spring.boot.test.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QueueWith2StacksTest {

    @Test
    public void testQueueWith2Stacks() {
        QueueWith2Stacks q = new QueueWith2Stacks();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        Assertions.assertEquals(1, q.dequeue());
        Assertions.assertEquals(2, q.dequeue());
        Assertions.assertEquals(3, q.dequeue());
        Assertions.assertTrue(q.isEmpty());
    }
}
