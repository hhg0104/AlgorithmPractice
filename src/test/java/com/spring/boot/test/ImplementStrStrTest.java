package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Implement strStr().

    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

    Clarification:

    What should we return when needle is an empty string? This is a great question to ask during an interview.

    For the purpose of this problem, we will return 0 when needle is an empty string.
    This is consistent to C's strstr() and Java's indexOf().


    Example 1:

    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Example 3:

    Input: haystack = "", needle = ""
    Output: 0


    Constraints:

    0 <= haystack.length, needle.length <= 5 * 104
    haystack and needle consist of only lower-case English characters.
 */
public class ImplementStrStrTest {

    @Test
    public void test() {

        int actual1 = strStr("hello", "ll");
        Assertions.assertEquals(2, actual1);

        int actual2 = strStr("aaaaa", "bba");
        Assertions.assertEquals(-1, actual2);

        int actual3 = strStr("", "");
        Assertions.assertEquals(0, actual3);

        int actual4 = strStr("mississippi", "issip");
        Assertions.assertEquals(4, actual4);


    }

    // Time complexity O(n), Space complexity O(1)
    private int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        }

        if (haystack == null || haystack.isEmpty()) {
            return -1;
        }

        int hLength = haystack.length();
        int nLength = needle.length();

        if (nLength > hLength) {
            return -1;
        }

        for (int i = 0; i < hLength - nLength + 1; i++) {
            int j = 0;
            for (j = 0; j < nLength; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }

            if (j == nLength) {
                return i;
            }
        }

        return -1;
    }
}
