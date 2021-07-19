package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/*
    Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

    Return the maximum possible length of s.


    Example 1:

    Input: arr = ["un","iq","ue"]
    Output: 4
    Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
    Maximum length is 4.
    Example 2:

    Input: arr = ["cha","r","act","ers"]
    Output: 6
    Explanation: Possible solutions are "chaers" and "acters".
    Example 3:

    Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
    Output: 26


    Constraints:

    1 <= arr.length <= 16
    1 <= arr[i].length <= 26
    arr[i] contains only lower case English letters.

    Time complexity: O(2^N)
    Space complexity: O(2^N)
 */
public class MaximumLengthOfConcatenatedStringWithUniqueCharactersTest {

    @Test
    public void test() {

        int actual1 = maxLength(Arrays.asList(new String[]{"un","iq","ue"}));
        Assertions.assertEquals(4, actual1);

        int actual2 = maxLength(Arrays.asList(new String[]{"cha","r","act","ers"}));
        Assertions.assertEquals(6, actual2);

        int actual3 = maxLength(Arrays.asList(new String[]{"abcdefghijklmnopqrstuvwxyz"}));
        Assertions.assertEquals(26, actual3);
    }

    public int maxLength(List<String> arr) {

        int[] max = new int[1];
        maxUnique(arr, 0, "", max);

        return max[0];
    }

    private void maxUnique(List<String> arr, int idx, String current, int[] max) {

        int uniqueStrCnt = countUniqueString(current);
        if (uniqueStrCnt == -1) {
            return;
        }

        if (idx == arr.size()) {
            if (uniqueStrCnt > max[0]) {
                max[0] = uniqueStrCnt;
            }

            return;
        }

        maxUnique(arr, idx + 1, current, max);
        maxUnique(arr, idx + 1, current + arr.get(idx), max);
    }

    private int countUniqueString(String str) {
        boolean[] exists = new boolean[26];
        for (char ch : str.toCharArray()) {
            if (exists[ch - 'a']) {
                return -1;
            } else {
                exists[ch - 'a'] = true;
            }
        }

        return str.length();
    }
}
