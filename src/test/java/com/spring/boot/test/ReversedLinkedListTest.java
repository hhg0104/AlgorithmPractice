package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given the head of a singly linked list, reverse the list, and return the reversed list.


    Example 1:

    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
    Example 2:


    Input: head = [1,2]
    Output: [2,1]
    Example 3:

    Input: head = []
    Output: []


    Constraints:

    The number of nodes in the list is the range [0, 5000].
    -5000 <= Node.val <= 5000
 */
public class ReversedLinkedListTest {

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
            node.next.next.next.next = new ListNode(5);

            ListNode actual = reverseList(node);
            Assertions.assertEquals(5, actual.val);
            Assertions.assertEquals(4, actual.next.val);
            Assertions.assertEquals(3, actual.next.next.val);
            Assertions.assertEquals(2, actual.next.next.next.val);
            Assertions.assertEquals(1, actual.next.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next.next);
        }
        {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);

            ListNode actual = reverseList(node);
            Assertions.assertEquals(2, actual.val);
            Assertions.assertEquals(1, actual.next.val);
            Assertions.assertEquals(null, actual.next.next);
        }
    }

    private ListNode reverseList(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;

            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }
}
