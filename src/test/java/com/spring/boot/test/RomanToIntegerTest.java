package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000
    For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
    Given a roman numeral, convert it to an integer.



    Example 1:

    Input: s = "III"
    Output: 3
    Example 2:

    Input: s = "IV"
    Output: 4
    Example 3:

    Input: s = "IX"
    Output: 9
    Example 4:

    Input: s = "LVIII"
    Output: 58
    Explanation: L = 50, V= 5, III = 3.
    Example 5:

    Input: s = "MCMXCIV"
    Output: 1994
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    Constraints:

    1 <= s.length <= 15
    s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
    It is guaranteed that s is a valid roman numeral in the range [1, 3999].

 */
public class RomanToIntegerTest {

    @Test
    public void test() {

        int actual1 = romanToInt1("III");
        Assertions.assertEquals(3, actual1);

        int actual2 = romanToInt1("IV");
        Assertions.assertEquals(4, actual2);

        int actual3 = romanToInt1("IX");
        Assertions.assertEquals(9, actual3);

        int actual4 = romanToInt1("LVIII");
        Assertions.assertEquals(58, actual4);

        int actual5 = romanToInt1("MCMXCIV");
        Assertions.assertEquals(1994, actual5);
    }

    public int romanToInt1(String romanStr) {

        int num[] = new int[romanStr.length()];
        for (int i = 0; i < romanStr.length(); i++) {
            char ch = romanStr.charAt(i);
            switch (ch) {
                case 'M': {
                    num[i] = 1000;
                    break;
                }
                case 'D': {
                    num[i] = 500;
                    break;
                }
                case 'C': {
                    num[i] = 100;
                    break;
                }
                case 'L': {
                    num[i] = 50;
                    break;
                }
                case 'X': {
                    num[i] = 10;
                    break;
                }
                case 'V': {
                    num[i] = 5;
                    break;
                }
                case 'I': {
                    num[i] = 1;
                    break;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] < num[i + 1]) {
                sum -= num[i];
            } else {
                sum += num[i];
            }
        }

        return sum + num[num.length - 1];
    }

    public int romanToIntWithMap(String romanStr) {

        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("IV", 4);
        romanMap.put("V", 5);
        romanMap.put("IX", 9);
        romanMap.put("X", 10);
        romanMap.put("XL", 40);
        romanMap.put("L", 50);
        romanMap.put("XC", 90);
        romanMap.put("C", 100);
        romanMap.put("CD", 400);
        romanMap.put("D", 500);
        romanMap.put("CM", 900);
        romanMap.put("M", 1000);

        int idx = 0;
        int result = 0;

        while (idx < romanStr.length()) {
            String str1 = romanStr.charAt(idx) + "";
            String str2 = "";
            if (idx + 1 < romanStr.length()) {
                str2 = romanStr.charAt(idx + 1) + "";
            }

            Integer num = romanMap.get(str1 + str2);
            if (num != null) {
                result += num;
                idx++;
            } else {
                result += romanMap.get(str1.charAt(0) + "");
            }

            idx++;
        }

        return result;
    }
}
