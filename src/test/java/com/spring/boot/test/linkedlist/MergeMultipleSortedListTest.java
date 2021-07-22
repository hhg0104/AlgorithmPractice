package com.spring.boot.test.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

    Merge all the linked-lists into one sorted linked-list and return it.


    Example 1:

    Input: lists = [[1,4,5],[1,3,4],[2,6]]
    Output: [1,1,2,3,4,4,5,6]
    Explanation: The linked-lists are:
    [
      1->4->5,
      1->3->4,
      2->6
    ]
    merging them into one sorted list:
    1->1->2->3->4->4->5->6
    Example 2:

    Input: lists = []
    Output: []
    Example 3:

    Input: lists = [[]]
    Output: []


    Constraints:

    k == lists.length
    0 <= k <= 10^4
    0 <= lists[i].length <= 500
    -10^4 <= lists[i][j] <= 10^4
    lists[i] is sorted in ascending order.
    The sum of lists[i].length won't exceed 10^4.
 */
public class MergeMultipleSortedListTest {

    @Test
    public void test() {

        {
            ListNode node1 = new ListNode(1);
            node1.next = new ListNode(4);
            node1.next.next = new ListNode(5);

            ListNode node2 = new ListNode(1);
            node2.next = new ListNode(3);
            node2.next.next = new ListNode(4);

            ListNode node3 = new ListNode(2);
            node3.next = new ListNode(6);

            ListNode actual = mergeKLists(new ListNode[]{node1, node2, node3}, 2);
            Assertions.assertEquals(1, actual.val);
            Assertions.assertEquals(1, actual.next.val);
            Assertions.assertEquals(2, actual.next.next.val);
            Assertions.assertEquals(3, actual.next.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.next.val);
            Assertions.assertEquals(4, actual.next.next.next.next.next.val);
            Assertions.assertEquals(5, actual.next.next.next.next.next.next.val);
            Assertions.assertEquals(6, actual.next.next.next.next.next.next.next.val);
            Assertions.assertEquals(null, actual.next.next.next.next.next.next.next.next);
        }

        {
            ListNode actual = mergeKLists(new ListNode[]{});
            Assertions.assertEquals(null, actual);
        }

        {
            ListNode actual = mergeKLists(new ListNode[]{null});
            Assertions.assertEquals(null, actual);
        }
    }

    /*
        time complexity: O(kN), space complexity: O(kN)
     */
    private ListNode mergeKLists(ListNode[] lists) {

        ListNode newListNode = new ListNode(0);
        ListNode tempNode = newListNode;
        while (isAllListNotNull(lists)) {
            ListNode leastNode = getLeastValueNode(lists);
            tempNode.next = new ListNode(leastNode.val);
            updateNodeList(lists, leastNode);
            tempNode = tempNode.next;
        }

        return newListNode.next;

    }

    private boolean isAllListNotNull(ListNode[] lists) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                return true;
            }
        }

        return false;
    }

    private ListNode getLeastValueNode(ListNode[] lists) {

        ListNode leastNode = null;
        for (int i = 0; i < lists.length; i++) {
            ListNode currentNode = lists[i];
            if (currentNode == null) {
                continue;
            }

            if (leastNode == null) {
                leastNode = currentNode;
                continue;
            }

            if (leastNode.val > currentNode.val) {
                leastNode = currentNode;
            }
        }

        return leastNode;
    }

    private void updateNodeList(ListNode[] lists, ListNode targetNode) {
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == targetNode) {
                lists[i] = targetNode.next;
                break;
            }
        }
    }

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

    // The main function that takes an array of lists
    // arr[0..last] and generates the sorted output
    public ListNode mergeKLists(ListNode arr[], int last)
    {
        // repeat until only one list is left
        while (last != 0) {
            int i = 0, j = last;

            // (i, j) forms a pair
            while (i < j) {
                // merge List i with List j and store
                // merged list in List i
                arr[i] = SortedMerge(arr[i], arr[j]);

                // consider next pair
                i++;
                j--;

                // If all pairs are merged, update last
                if (i >= j)
                    last = j;
            }
        }

        return arr[0];
    }

    /* Takes two lists sorted in increasing order, and merge
    their nodes together to make one big sorted list. Below
    function takes O(Log n) extra space for recursive calls,
    but it can be easily modified to work with same time and
    O(1) extra space  */
    public ListNode SortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
        /* Base cases */
        if (a == null)
            return b;
        else if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.val <= b.val) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = SortedMerge(a, b.next);
        }

        return result;
    }
}
