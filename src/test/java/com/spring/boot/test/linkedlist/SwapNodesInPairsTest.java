package com.spring.boot.test.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given a linked list, swap every two adjacent nodes and return its head.
    You must solve the problem without modifying the values in the list's nodes
    (i.e., only nodes themselves may be changed.)


    Example 1:


    Input: head = [1,2,3,4]
    Output: [2,1,4,3]
    Example 2:

    Input: head = []
    Output: []
    Example 3:

    Input: head = [1]
    Output: [1]


    Constraints:

    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
 */
public class SwapNodesInPairsTest {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void test() {
        {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);

            ListNode actual = swapPairs(node);
            Assertions.assertEquals(2, actual.val);
            Assertions.assertEquals(1, actual.next.val);
            Assertions.assertEquals(4, actual.next.next.val);
            Assertions.assertEquals(3, actual.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next);
        }
        {
            ListNode actual = swapPairs(null);
            Assertions.assertEquals(null, actual);
        }
        {
            ListNode node = new ListNode(1);

            ListNode actual = swapPairs(node);
            Assertions.assertEquals(1, actual.val);
            Assertions.assertEquals(null, actual.next);
        }
    }

    // Time complexity: O(n), Space complexity: O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        curr.next = head;

        while(curr != null && curr.next != null && curr.next.next != null) {
            ListNode next1 = curr.next;
            ListNode next2 = curr.next.next;
            ListNode next3 = curr.next.next.next;

            curr.next = next2;
            next2.next = next1;
            next1.next = next3;

            curr = curr.next.next;
        }

        return dummy.next;
    }
}
