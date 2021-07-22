package com.spring.boot.test.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.


    Example 1:


    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]
    Example 2:

    Input: l1 = [], l2 = []
    Output: []
    Example 3:

    Input: l1 = [], l2 = [0]
    Output: [0]


    Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both l1 and l2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedListsTest {

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
            ListNode node1 = new ListNode(1);
            node1.next = new ListNode(2);
            node1.next.next = new ListNode(4);

            ListNode node2 = new ListNode(1);
            node2.next = new ListNode(3);
            node2.next.next = new ListNode(4);

            ListNode actual = mergeTwoLists(node1, node2);
            Assertions.assertEquals(1, actual.val);
            Assertions.assertEquals(1, actual.next.val);
            Assertions.assertEquals(2, actual.next.next.val);
            Assertions.assertEquals(3, actual.next.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.next.next.val);
        }
        {
            ListNode actual = mergeTwoLists(null, null);
            Assertions.assertEquals(null, actual);
        }
        {
            ListNode actual = mergeTwoLists(null, new ListNode(0));
            Assertions.assertEquals(0, actual.val);
        }
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedNode = new ListNode();

        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode cur = mergedNode;
        while (node1 != null || node2 != null) {

            if (node2 == null || (node1 != null && node1.val < node2.val)) {
                cur.next = node1;
                node1 = node1.next;

            } else if (node1 == null || (node2 != null && node1.val >= node2.val)) {
                cur.next = node2;
                node2 = node2.next;
            }

            cur = cur.next;
        }

        return mergedNode.next;
    }
}
