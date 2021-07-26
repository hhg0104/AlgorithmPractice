package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/*
    Given a string s and a dictionary of strings wordDict,
    return true if s can be segmented into a space-separated sequence of one or more dictionary words.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.


    Example 1:

    Input: s = "leetcode", wordDict = ["leet","code"]
    Output: true
    Explanation: Return true because "leetcode" can be segmented as "leet code".
    Example 2:

    Input: s = "applepenapple", wordDict = ["apple","pen"]
    Output: true
    Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
    Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: false


    Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
 */
public class WordBreakTest {

    @Test
    public void test() {

        boolean actual1 = wordBreak("leetcode", Arrays.asList(new String[]{"leet","code"}));
        Assertions.assertEquals(true, actual1);

        boolean actual2 = wordBreak("applepenapple", Arrays.asList(new String[]{"apple","pen"}));
        Assertions.assertEquals(true, actual2);

        boolean actual3 = wordBreak("catsandog", Arrays.asList(new String[]{"cats","dog","sand","and","cat"}));
        Assertions.assertEquals(false, actual3);

        boolean actual4 = wordBreak("abcd", Arrays.asList(new String[]{"a","abc","b","cd"}));
        Assertions.assertEquals(true, actual4);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) {
            return false;
        }

        return isBreakable(s, wordDict, 0, new Boolean[s.length()]);
    }

    private boolean isBreakable(String text, List<String> wordDict, int idx, Boolean[] cache) {

        if (idx == text.length()) {
            return true;
        }

        if (cache[idx] != null) {
            return cache[idx];
        }

        boolean ans = false;
        for (String word : wordDict) {
            if (!ans && text.substring(idx).startsWith(word)) {
                ans = isBreakable(text, wordDict, idx + word.length(), cache);
            }
        }

        cache[idx] = ans;
        return ans;
    }
}
