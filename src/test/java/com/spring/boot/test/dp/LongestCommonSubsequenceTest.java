package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
    Given two strings text1 and text2, return the length of their longest common subsequence.
    If there is no common subsequence, return 0.

    A subsequence of a string is a new string generated from the original string
    with some characters (can be none) deleted
    without changing the relative order of the remaining characters.

    For example, "ace" is a subsequence of "abcde".
    A common subsequence of two strings is a subsequence that is common to both strings.


    Example 1:

    Input: text1 = "abcde", text2 = "ace"
    Output: 3
    Explanation: The longest common subsequence is "ace" and its length is 3.
    Example 2:

    Input: text1 = "abc", text2 = "abc"
    Output: 3
    Explanation: The longest common subsequence is "abc" and its length is 3.
    Example 3:

    Input: text1 = "abc", text2 = "def"
    Output: 0
    Explanation: There is no such common subsequence, so the result is 0.


    Constraints:

    1 <= text1.length, text2.length <= 1000
    text1 and text2 consist of only lowercase English characters.


    Time Complexity: O(n^2)
    Space Complexity: O(n)
*/
public class LongestCommonSubsequenceTest {

    @Test
    public void test() {

        int length1 = longestCommonSubsequence("abcde", "ace");
        Assertions.assertEquals(3, length1);

        int length2 = longestCommonSubsequence("abc", "abc");
        Assertions.assertEquals(3, length2);

        int length3 = longestCommonSubsequence("abc", "def");
        Assertions.assertEquals(0, length3);

    }

    public int longestCommonSubsequence(String text1, String text2) {

        if (text1.length() == 0 || text2.length() == 0) {
            return 0;
        }

        int length1 = text1.length();
        int length2 = text2.length();

        int[][] map = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            for (int j = 0; j <= length2; j++) {
                if (i == 0 || j == 0) {
                    map[i][j] = 0;
                    continue;
                }

                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                if (ch1 == ch2) {
                    map[i][j] = map[i - 1][j - 1] + 1;

                } else {
                    map[i][j] = Math.max(map[i - 1][j], map[i][j - 1]);
                }
            }
        }

        return map[length1][length2];
    }
}