package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
    Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:

    '.' Matches any single character.​​​​
    '*' Matches zero or more of the preceding element.
    The matching should cover the entire input string (not partial).


    Example 1:

    Input: s = "aa", p = "a"
    Output: false
    Explanation: "a" does not match the entire string "aa".
    Example 2:

    Input: s = "aa", p = "a*"
    Output: true
    Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
    Example 3:

    Input: s = "ab", p = ".*"
    Output: true
    Explanation: ".*" means "zero or more (*) of any character (.)".
    Example 4:

    Input: s = "aab", p = "c*a*b"
    Output: true
    Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
    Example 5:

    Input: s = "mississippi", p = "mis*is*p*."
    Output: false


    Constraints:

    0 <= s.length <= 20
    0 <= p.length <= 30
    s contains only lowercase English letters.
    p contains only lowercase English letters, '.', and '*'.
    It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 */
public class RegularExpressionMatchingTest {

    @Test
    public void test() {

        boolean actual1 = isMatch("aa", "aa");
        Assertions.assertTrue(actual1);

        boolean actual2 = isMatch("aa", "a*");
        Assertions.assertTrue(actual2);

        boolean actual3 = isMatch("ab", ".*");
        Assertions.assertTrue(actual3);

        boolean actual4 = isMatch("aab", "c*a*b");
        Assertions.assertTrue(actual4);

        boolean actual5 = isMatch("aa", "a");
        Assertions.assertFalse(actual5);

        boolean actual6 = isMatch("mississippi", "mis*is*p*.");
        Assertions.assertFalse(actual6);
    }

    public boolean isMatch(String s, String p) {
        Map<String, Boolean> cacheMap = new HashMap<>();
        return search(s, p, cacheMap);
    }

    private boolean search(String s, String p, Map<String, Boolean> cacheMap) {

        String key = s + "-" + p;
        if (cacheMap.containsKey(key)) {
            return cacheMap.get(key);
        }

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean isFirstMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        boolean ans = false;
        if (p.length() >= 2 && p.charAt(1) == '*') {
            ans = search(s, p.substring(2), cacheMap) || (isFirstMatched && search(s.substring(1), p, cacheMap));

        } else {
            if (isFirstMatched) {
                ans = search(s.substring(1), p.substring(1), cacheMap);
            } else {
                return false;
            }
        }

        cacheMap.put(key, ans);

        return ans;
    }
}
