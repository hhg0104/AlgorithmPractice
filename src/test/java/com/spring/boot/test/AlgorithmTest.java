package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class AlgorithmTest {

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

        while(list1 != null || list2 != null) {

            int v1 = list1.val;
            int v2 = list2.val;

            int sum = carry + v1 + v2;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if(list1 != null) {
                list1 = list1.next;
            }
            if(list2 != null) {
                list2 = list2.next;
            }
        }

        if(carry > 0) {
            current.next = new ListNode(carry);
        }

        return newNode.next;
    }

    @Test
    public void testLongestSubstring() {

        String str1 = "abcabcbb";
        int length1 = getLongestSubString2(str1);
        System.out.println(length1);

        Assertions.assertEquals(length1, 3);

        String str2 = "bbbbb";
        int length2 = getLongestSubString2(str2);
        System.out.println(length2);

        Assertions.assertEquals(length2, 1);

        String str3 = "pwwkew";
        int length3 = getLongestSubString2(str3);
        System.out.println(length3);

        Assertions.assertEquals(length3, 3);

        String str4 = "";
        int length4 = getLongestSubString2(str4);
        System.out.println(length4);

        Assertions.assertEquals(length4, 0);

        String str5 = "가나다나가다나나";
        int length5 = getLongestSubString2(str5);
        System.out.println(length5);

        Assertions.assertEquals(length5, 3);
    }

    // o(2n)
    public int lengthOfLongestSubstring(String s) {

        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {

            char ch = s.charAt(j);
            System.out.println(j + " : " + i + " : " + ch);

            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }
            ans = Math.max(ans, j - i + 1);
            System.out.println("ans: " + ans);
            map.put(ch, j + 1);
        }

        System.out.println("-------------------");
        map.forEach((key, value) -> System.out.println(key + " : " + value + " : "));

        return ans;
    }

    // o(2n)
    public int lengthOfLongestSubstringCustom(String s) {

        int lengthOfLongestSubstring = 0;
        Map<Character, Integer> map = new HashMap<>();

        int duplicateCharIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                duplicateCharIndex = Math.max(map.get(ch), duplicateCharIndex);
            }
            System.out.println(i + " : " + duplicateCharIndex + " : " + ch);

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i - duplicateCharIndex + 1);
            System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring);

            map.put(ch, i + 1);
        }

        System.out.println("-------------------");
        map.forEach((key, value) -> System.out.println(key + " : " + value + " : "));

        return lengthOfLongestSubstring;
    }

    // o(n)
    private int lengthOfLongestSubstring2(String s) {

        int ans = 0;
        int[] index = new int[Character.MAX_VALUE]; // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {

//            System.out.println(s.charAt(j));
//            System.out.println(s.charAt(i));

            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return ans;
    }

    private int getLongestSubString(String str) {

        if(str == null || str.length() == 0) {
            return 0;
        }

        int maxSubstringLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int duplicateCharIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(map.containsKey(ch)) {
                int charIdx = map.get(ch);
                if (charIdx > duplicateCharIndex) {
                    duplicateCharIndex = charIdx;
                }
            }

            int subStrLength = i - duplicateCharIndex + 1;
            if(subStrLength > maxSubstringLength) {
                maxSubstringLength = subStrLength;
            }

            map.put(ch, i + 1);
        }

        return maxSubstringLength;
    }

    private int getLongestSubString2(String str) {

        if(str == null || str.length() == 0) {
            return 0;
        }

        int maxLength = 0;

        int[] intArr = new int[Character.MAX_VALUE];
        int duplicateCharIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            duplicateCharIndex = Math.max(duplicateCharIndex, intArr[ch]);
            maxLength = Math.max(maxLength, i - duplicateCharIndex);
            intArr[ch] = i;
        }

        return maxLength;
    }
}
