package com.spring.boot.test;

import org.junit.jupiter.api.Test;

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
        ListNode curr = result;
        while (true) {
            System.out.println(curr.val);
            if (curr.next == null) {
                break;
            }
            curr = curr.next;
        }
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
