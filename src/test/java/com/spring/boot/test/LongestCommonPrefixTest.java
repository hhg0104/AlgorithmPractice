package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".



    Example 1:

    Input: strs = ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: strs = ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.


    Constraints:

    1 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] consists of only lower-case English letters.
 */
public class LongestCommonPrefixTest {

    @Test
    public void test() {

        String actual1 = longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Assertions.assertEquals("fl", actual1);

        String actual2 = longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        Assertions.assertEquals("", actual2);

        String actual3 = longestCommonPrefix(new String[]{"ab", "a"});
        Assertions.assertEquals("a", actual3);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(firstStr) != 0) {
                firstStr = firstStr.substring(0, firstStr.length() - 1);
            }

            if (firstStr == "") {
                break;
            }
        }

        return firstStr;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < firstStr.length()) {
            char ch = firstStr.charAt(idx);
            boolean isMatched = true;
            for (int i = 1; i < strs.length; i++) {
                String str = strs[i];
                if (idx >= str.length()) {
                    return sb.toString();
                }

                if (ch != str.charAt(idx)) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched) {
                sb.append(ch);
            } else {
                return sb.toString();
            }

            idx++;
        }

        return sb.toString();
    }
}
