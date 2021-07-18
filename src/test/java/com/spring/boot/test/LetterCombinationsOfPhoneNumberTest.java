package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
    Given a string containing digits from 2-9 inclusive,
    return all possible letter combinations that the number could represent.
    Return the answer in any order.

    A mapping of digit to letters (just like on the telephone buttons) is given below.
    Note that 1 does not map to any letters.


    Example 1:

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:

    Input: digits = ""
    Output: []
    Example 3:

    Input: digits = "2"
    Output: ["a","b","c"]


    Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].

    Time complexity: O(3^N * 4^M)
    Space complexity: O(3^N * 4^M)

    where N is the number of digits in the input that maps to 3 letters and M is the number of digits in the input that
    maps to 4 letters, N+M is the total number digits in the input.
 */
public class LetterCombinationsOfPhoneNumberTest {

    @Test
    public void test() {

        List<String> actual1 = letterCombinations("23");
        Assertions.assertEquals(9, actual1.size());
        Assertions.assertEquals("ad", actual1.get(0));
        Assertions.assertEquals("ae", actual1.get(1));
        Assertions.assertEquals("af", actual1.get(2));
        Assertions.assertEquals("bd", actual1.get(3));
        Assertions.assertEquals("be", actual1.get(4));
        Assertions.assertEquals("bf", actual1.get(5));
        Assertions.assertEquals("cd", actual1.get(6));
        Assertions.assertEquals("ce", actual1.get(7));
        Assertions.assertEquals("cf", actual1.get(8));

        List<String> actual2 = letterCombinations("2");
        Assertions.assertEquals(3, actual2.size());
        Assertions.assertEquals("a", actual2.get(0));
        Assertions.assertEquals("b", actual2.get(1));
        Assertions.assertEquals("c", actual2.get(2));

        List<String> actual3 = letterCombinations("7");
        Assertions.assertEquals(4, actual3.size());
        Assertions.assertEquals("p", actual3.get(0));
        Assertions.assertEquals("q", actual3.get(1));
        Assertions.assertEquals("r", actual3.get(2));
        Assertions.assertEquals("s", actual3.get(3));

        List<String> actual4 = letterCombinations("");
        Assertions.assertEquals(0, actual4.size());
    }

    private List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if (digits.isEmpty()) {
            return list;
        }

        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        addLetterCombination(digits, mapping, "", 0, list);

        return list;
    }

    private void addLetterCombination(String digits, String[] mapping, String str, int idx, List<String> list) {

        if (str.length() == digits.length()) {
            list.add(str);
            return;
        }

        String buttonStr = mapping[digits.charAt(idx) - '0'];

        for (int i = 0; i < buttonStr.length(); i++) {
            addLetterCombination(digits, mapping, str + buttonStr.charAt(i), idx + 1, list);
        }
    }
}
