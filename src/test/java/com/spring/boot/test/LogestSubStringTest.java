package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class LogestSubStringTest {


    @Test
    public void testLongestSubstring() {

        String str1 = "abcabcbb";
        int length1 = lengthOfLongestSubstringUsingMap(str1);
        System.out.println(length1);

        Assertions.assertEquals(length1, 3);

        String str2 = "bbbbb";
        int length2 = lengthOfLongestSubstringUsingMap(str2);
        System.out.println(length2);

        Assertions.assertEquals(length2, 1);

        String str3 = "pwwkew";
        int length3 = lengthOfLongestSubstringUsingMap(str3);
        System.out.println(length3);

        Assertions.assertEquals(length3, 3);

        String str4 = "";
        int length4 = lengthOfLongestSubstringUsingMap(str4);
        System.out.println(length4);

        Assertions.assertEquals(length4, 0);

        String str5 = "가나다나가다나나";
        int length5 = lengthOfLongestSubstringUsingMap(str5);
        System.out.println(length5);

        Assertions.assertEquals(length5, 3);
    }

    private int getLongestSubString2(String str) {

        if(str == null || str.length() == 0) {
            return 0;
        }

        int maxLength = 0;

        int[] intArr = new int[Character.MAX_VALUE];
        int duplicateCharIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            duplicateCharIndex = Math.max(duplicateCharIndex, intArr[ch]);
            maxLength = Math.max(maxLength, i - duplicateCharIndex);
            intArr[ch] = i;
        }

        return maxLength;
    }

    // o(2n)
    public int lengthOfLongestSubstring(String s) {

        int ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {

            char ch = s.charAt(j);
            System.out.println(j + " : " + i + " : " + ch);

            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch), i);
            }
            ans = Math.max(ans, j - i + 1);
            System.out.println("ans: " + ans);
            map.put(ch, j + 1);
        }

        System.out.println("-------------------");
        map.forEach((key, value) -> System.out.println(key + " : " + value + " : "));

        return ans;
    }

    // o(2n)
    public int lengthOfLongestSubstringUsingMap(String s) {

        int lengthOfLongestSubstring = 0;
        Map<Character, Integer> map = new HashMap<>();

        int duplicateCharIndex = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                duplicateCharIndex = Math.max(map.get(ch), duplicateCharIndex);
            }
            System.out.println(i + " : " + duplicateCharIndex + " : " + ch);

            lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, i - duplicateCharIndex);
            System.out.println("lengthOfLongestSubstring: " + lengthOfLongestSubstring);

            map.put(ch, i);
        }

        System.out.println("-------------------");
        map.forEach((key, value) -> System.out.println(key + " : " + value + " : "));

        return lengthOfLongestSubstring;
    }

    // o(n)
    private int lengthOfLongestSubstring2(String s) {

        int ans = 0;
        int[] index = new int[Character.MAX_VALUE]; // current index of character

        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < s.length(); j++) {

//            System.out.println(s.charAt(j));
//            System.out.println(s.charAt(i));

            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }

        return ans;
    }

    private int getLongestSubString(String str) {

        if(str == null || str.length() == 0) {
            return 0;
        }

        int maxSubstringLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        int duplicateCharIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if(map.containsKey(ch)) {
                int charIdx = map.get(ch);
                if (charIdx > duplicateCharIndex) {
                    duplicateCharIndex = charIdx;
                }
            }

            int subStrLength = i - duplicateCharIndex + 1;
            if(subStrLength > maxSubstringLength) {
                maxSubstringLength = subStrLength;
            }

            map.put(ch, i + 1);
        }

        return maxSubstringLength;
    }
}
