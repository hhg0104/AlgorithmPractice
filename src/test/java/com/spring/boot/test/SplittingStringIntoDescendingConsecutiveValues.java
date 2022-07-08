package com.spring.boot.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    You are given a string s that consists of only digits.

    Check if we can split s into two or more non-empty substrings such that the numerical values of the substrings are in descending order and the difference between numerical values of every two adjacent substrings is equal to 1.

    For example, the string s = "0090089" can be split into ["0090", "089"] with numerical values [90,89]. The values are in descending order and adjacent values differ by 1, so this way is valid.
    Another example, the string s = "001" can be split into ["0", "01"], ["00", "1"], or ["0", "0", "1"]. However all the ways are invalid because they have numerical values [0,1], [0,1], and [0,0,1] respectively, all of which are not in descending order.
    Return true if it is possible to split s​​​​​​ as described above, or false otherwise.

    A substring is a contiguous sequence of characters in a string.



    Example 1:

    Input: s = "1234"
    Output: false
    Explanation: There is no valid way to split s.
    Example 2:

    Input: s = "050043"
    Output: true
    Explanation: s can be split into ["05", "004", "3"] with numerical values [5,4,3].
    The values are in descending order with adjacent values differing by 1.
    Example 3:

    Input: s = "9080701"
    Output: false
    Explanation: There is no valid way to split s.
    Example 4:

    Input: s = "10009998"
    Output: true
    Explanation: s can be split into ["100", "099", "98"] with numerical values [100,99,98].
    The values are in descending order with adjacent values differing by 1.


    Constraints:

    1 <= s.length <= 20
    s only consists of digits.
*/
public class SplittingStringIntoDescendingConsecutiveValues {

    @Data
    @AllArgsConstructor
    private class TwoNum {

        private int first;

        private int second;
    }

    @Test
    public void test() {

        boolean answer1 = splitString("1234");
        Assertions.assertEquals(false, answer1);

        boolean answer2 = splitString("050043");
        Assertions.assertEquals(true, answer2);

        boolean answer3 = splitString("9080701");
        Assertions.assertEquals(false, answer3);

        boolean answer4 = splitString("10009998");
        Assertions.assertEquals(true, answer4);

        boolean answer5 = splitString("99999999999999999998");
        Assertions.assertEquals(true, answer5);

    }

    /*
     * Time Complexity: O(N*N), N = the length of s string
     *
     * Space Complexity: O(1)
     *
     */
    public boolean splitString(String s) {

        long first = 0;

        // find the first number of the sequence
        for (int i = 0; i < s.length() - 1; i++) {
            first = first * 10 + s.charAt(i) - '0';

            if (helper(first, s, i + 1)){
                return true;
            }
        }
        return false;
    }

    private boolean helper(long pre, String s, int idx) {

        long next = 0;
        // check the next number is equal to (previous number -1)
        for (int i = idx; i < s.length(); i++) {
            next = next * 10 + s.charAt(i) - '0';

            if (next == 0 && i != s.length() - 1) {
                continue;
            }

            if (pre - 1 == next) {
                pre = next;
                next = 0;

            } else if (next >= pre || i == s.length() - 1) {
                return false;
            }
        }

        return true;
    }
}
