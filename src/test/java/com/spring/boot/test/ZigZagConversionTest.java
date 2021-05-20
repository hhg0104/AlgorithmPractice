package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/*
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
    (you may want to display this pattern in a fixed font for better legibility)

    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"

    Write the code that will take a string and make this conversion given a number of rows:

    string convert(string s, int numRows);


    Example 1:

    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"
    Explanation:
    P    A   H    N     0     4    8    12
    A  P L S I  I G     1  3  5  7 9 11 13
    Y    I   R          2     6    10

    Example 2:

    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:
    P     I    N    0(0)           6(1)              12(2) 3
    A   L S  I G    1(3)      5(4) 7(5)        11(6) 13(7) 5
    Y A   H R       2(8)  4(9)     8(10) 10(11)            4
    P     I         3(12)          9(13)                   2
    Example 3:

    Input: s = "A", numRows = 1
    Output: "A"


    Constraints:

    1 <= s.length <= 1000
    s consists of English letters (lower-case and upper-case), ',' and '.'.
    1 <= numRows <= 1000
 */
public class ZigZagConversionTest {

    @Test
    public void test() {

        String actual1 = convertZigzag("PAYPALISHIRING", 3);
        Assertions.assertEquals("PAHNAPLSIIGYIR", actual1);

        String actual2 = convertZigzag("PAYPALISHIRING", 4);
        Assertions.assertEquals("PINALSIGYAHRPI", actual2);

        String actual3 = convertZigzag("AB", 3);
        Assertions.assertEquals("AB", actual3);

        String actual4 = convertZigzag("ABCD", 3);
        Assertions.assertEquals("ABDC", actual4);
    }

    private String convertZigzag(String str, int rowsNum) {

        int len = str.length();
        if (str == null || str.isEmpty() || len > 1000 || rowsNum > 1000) {
            return null;
        }

        if (len == 1 || rowsNum == 1 || rowsNum >= len) {
            return str;
        }

        int cycleLen = rowsNum * 2 - 2;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < rowsNum; i++) {
            sb.append(str.charAt(i));

            // if first or last row
            if (i == 0 || i == rowsNum - 1) {
                int idx = cycleLen + i;

                while (idx < len) {
                    sb.append(str.charAt(idx));
                    idx += cycleLen;
                }
                continue;
            }

            int idx = cycleLen;
            while (idx - i < len) {
                sb.append(str.charAt(idx - i));
                if (idx + i < len) {
                    sb.append(str.charAt(idx + i));
                }

                idx += cycleLen;
            }
        }

        return sb.toString();
    }
}
