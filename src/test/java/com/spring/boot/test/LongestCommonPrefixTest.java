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
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 1; i < strs[0].length(); i++) {
            while (strs[i].indexOf(strs[0]) != 0) {
                strs[0] = strs[0].substring(0, strs[0].length() - 1);
            }

            if (strs[0] == "") {
                break;
            }
        }

        return strs[0];
    }
}
