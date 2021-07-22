package com.spring.boot.test.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [2,4,3], l2 = [5,6,4]
    Output: [7,0,8]
    Explanation: 342 + 465 = 807.
    Example 2:

    Input: l1 = [0], l2 = [0]
    Output: [0]
    Example 3:

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]


    Constraints:

    The number of nodes in each linked list is in the range [1, 100].
    0 <= Node.val <= 9
    It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class AddListNodeNumberTest {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    @Test
    public void testAddNumbers() {

        ListNode l3 = new ListNode(8);
        ListNode l2 = new ListNode(4, l3);
        ListNode l1 = new ListNode(2, l2);

        ListNode l6 = new ListNode(4);
        ListNode l5 = new ListNode(6, l6);
        ListNode l4 = new ListNode(5, l5);

        ListNode result = addNumbers(l1, l4);

        Assertions.assertEquals(7, result.val);
        Assertions.assertEquals(0, result.next.val);
        Assertions.assertEquals(3, result.next.next.val);
        Assertions.assertEquals(1, result.next.next.next.val);
        Assertions.assertNull(result.next.next.next.next);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = dummyHead;

        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    private ListNode addNumbers(ListNode list1, ListNode list2) {

        ListNode newNode = new ListNode(0);
        ListNode current = newNode;
        int carry = 0;

        while (list1 != null || list2 != null) {

            int v1 = list1.val;
            int v2 = list2.val;

            int sum = carry + v1 + v2;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (list1 != null) {
                list1 = list1.next;
            }
            if (list2 != null) {
                list2 = list2.next;
            }
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return newNode.next;
    }

}
