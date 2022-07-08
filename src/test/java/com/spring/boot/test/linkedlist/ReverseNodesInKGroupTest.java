package com.spring.boot.test.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
    k is a positive integer and is less than or equal to the length of the linked list.
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
    You may not alter the values in the list's nodes, only nodes themselves may be changed.



    Example 1:


    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
    Example 2:


    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]
    Example 3:

    Input: head = [1,2,3,4,5], k = 1
    Output: [1,2,3,4,5]
    Example 4:

    Input: head = [1], k = 1
    Output: [1]


    Constraints:

    The number of nodes in the list is in the range sz.
    1 <= sz <= 5000
    0 <= Node.val <= 1000
    1 <= k <= sz


    Follow-up: Can you solve the problem in O(1) extra memory space?

    Time complexity: O(n)
    Space complexity: O(1)
 */
public class ReverseNodesInKGroupTest {

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

            ListNode actual = reverseKGroup(node, 2);
            print(actual);

            Assertions.assertEquals(2, actual.val);
            Assertions.assertEquals(1, actual.next.val);
            Assertions.assertEquals(4, actual.next.next.val);
            Assertions.assertEquals(3, actual.next.next.next.val);
            Assertions.assertEquals(5, actual.next.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next.next);
        }
        {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);

            ListNode actual = reverseKGroup(node, 3);
            print(actual);

            Assertions.assertEquals(3, actual.val);
            Assertions.assertEquals(2, actual.next.val);
            Assertions.assertEquals(1, actual.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.val);
            Assertions.assertEquals(5, actual.next.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next.next);
        }
        {
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);

            ListNode actual = reverseKGroup(node, 1);
            print(actual);

            Assertions.assertEquals(1, actual.val);
            Assertions.assertEquals(2, actual.next.val);
            Assertions.assertEquals(3, actual.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.val);
            Assertions.assertEquals(5, actual.next.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next.next);
        }
        {
            ListNode node = new ListNode(1);

            ListNode actual = reverseKGroup(node, 1);
            print(actual);

            Assertions.assertEquals(1, actual.val);
            Assertions.assertEquals(null, actual.next);
        }
    }

    // Time complexity: O(n), Space complexity: O(1)
    private ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, p.next);
                p = prev.next;
            } else {
                p = p.next;
            }
        }

        return dummy.next;
    }

    //[1,2,3,4,5]
    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }

        return last;
    }

    private void print(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println("");
    }
}
