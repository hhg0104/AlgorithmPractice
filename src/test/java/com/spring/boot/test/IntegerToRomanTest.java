package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    Given an integer, convert it to a roman numeral.



    Example 1:

    Input: num = 3
    Output: "III"
    Example 2:

    Input: num = 4
    Output: "IV"
    Example 3:

    Input: num = 9
    Output: "IX"
    Example 4:

    Input: num = 58
    Output: "LVIII"
    Explanation: L = 50, V = 5, III = 3.
    Example 5:

    Input: num = 1994
    Output: "MCMXCIV"
    Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


    Constraints:

    1 <= num <= 3999

 */
public class IntegerToRomanTest {

    @Test
    public void test() {

        String actual1 = intToRoman(3);
        Assertions.assertEquals("III", actual1);

        String actual2 = intToRoman(4);
        Assertions.assertEquals("IV", actual2);

        String actual3 = intToRoman(9);
        Assertions.assertEquals("IX", actual3);

        String actual4 = intToRoman(58);
        Assertions.assertEquals("LVIII", actual4);

        String actual5 = intToRoman(1994);
        Assertions.assertEquals("MCMXCIV", actual5);
    }

    private enum Roman {

        I(1),
        IV(4),
        V(5),
        IX(9),
        X(10),
        XL(40),
        L(50),
        XC(90),
        C(100),
        CD(400),
        D(500),
        CM(900),
        M(1000);

        private int val;

        Roman(int val) {
            this.val = val;
        }

        private int getVal() {
            return this.val;
        }
    }

    private String intToRoman(int num) {

        if (num <= 0) {
            return "";
        }

        Roman[] values = Roman.values();
        int idx = values.length - 1;
        String result = "";

        while (idx >= 0) {
            Roman romanNum = values[idx];
            int val = romanNum.getVal();
            int share = num / val;
            if (share > 0) {
                result += repeatStr(romanNum.name(), share);
                num %= val;
            }

            idx--;
        }


        return result;
    }

    private String repeatStr(String str, int count) {

        String result = "";

        for (int i = 0; i < count; i++) {
            result += str;
        }

        return result;
    }
}
