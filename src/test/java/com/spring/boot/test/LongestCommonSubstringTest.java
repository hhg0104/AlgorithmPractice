package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given a string s, return the longest palindromic substring in s.


    Example 1:

    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.
    Example 2:

    Input: s = "cbbd"
    Output: "bb"
    Example 3:

    Input: s = "a"
    Output: "a"
    Example 4:

    Input: s = "ac"
    Output: "a"


    Constraints:

    1 <= s.length <= 1000
    s consist of only digits and English letters (lower-case and/or upper-case),


    time complexity: O(n2)
    space complexity: O(n2)
 */
public class LongestCommonSubstringTest {

    @Test
    public void test() {

        String actual1 = longestPalindromeSelf("babad");
        Assertions.assertEquals("bab", actual1);

        String actual2 = longestPalindromeSelf("cbbd");
        Assertions.assertEquals("bb", actual2);

        String actual3 = longestPalindromeSelf("a");
        Assertions.assertEquals("a", actual3);

        String actual4 = longestPalindromeSelf("ac");
        Assertions.assertEquals("a", actual4);
    }

    private String longestPalindromeSelf(String str) {

        if (str == null || str.isEmpty() || str.length() > 1000) {
            return null;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < str.length(); i++) {
            int oddLen = searchPalindromeFromCenter(str, i, i);
            int evenLen = searchPalindromeFromCenter(str, i, i + 1);

            int len = Math.max(oddLen, evenLen);

            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return str.substring(start, end + 1);
    }

    private int searchPalindromeFromCenter(String str, int start, int end) {

        while ((start >= 0 && end < str.length()) && (str.charAt(start) == str.charAt(end))) {
            start--;
            end++;
        }

        return end - start - 1;
    }

    private String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
