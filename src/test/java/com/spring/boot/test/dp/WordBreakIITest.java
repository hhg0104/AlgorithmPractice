package com.spring.boot.test.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
    Given a string s and a dictionary of strings wordDict,
    add spaces in s to construct a sentence where each word is a valid dictionary word.
    Return all such possible sentences in any order.

    Note that the same word in the dictionary may be reused multiple times in the segmentation.


    Example 1:

    Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
    Output: ["cats and dog","cat sand dog"]
    Example 2:

    Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
    Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
    Explanation: Note that you are allowed to reuse a dictionary word.
    Example 3:

    Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
    Output: []


    Constraints:

    1 <= s.length <= 20
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 10
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
 */
public class WordBreakIITest {

    @Test
    public void test() {

        List<String> actual1 = wordBreak("catsanddog", Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"}));
        Assertions.assertEquals(2, actual1.size());
        Assertions.assertEquals("cat sand dog", actual1.get(0));
        Assertions.assertEquals("cats and dog", actual1.get(1));

        List<String> actual2 = wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"}));
        Assertions.assertEquals(true, actual2.isEmpty());

        List<String> actual3 = wordBreak("pineapplepenapple", Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"}));
        Assertions.assertEquals(3, actual3.size());
        Assertions.assertEquals("pine apple pen apple", actual3.get(0));
        Assertions.assertEquals("pine applepen apple", actual3.get(1));
        Assertions.assertEquals("pineapple pen apple", actual3.get(2));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) {
            return Collections.emptyList();
        }

        List<String> list = new ArrayList<>();
        isBreakable(s, wordDict, list, "");
        return list;
    }

    private void isBreakable(String s, List<String> wordDict, List<String> list, String str) {
        if (s.length() == 0) {
            list.add(str.substring(1));
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i + 1);
            if (wordDict.contains(sub)){
                isBreakable(s.substring(i + 1), wordDict, list, str + " " + sub);
            }
        }
    }
}
