package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given two integers dividend and divisor, divide two integers
    without using multiplication, division, and mod operator.

    Return the quotient after dividing dividend by divisor.

    The integer division should truncate toward zero, which means losing its fractional part.
    For example, truncate(8.345) = 8 and truncate(-2.7335) = -2.

    Note: Assume we are dealing with an environment that could only store integers
    within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.



    Example 1:

    Input: dividend = 10, divisor = 3
    Output: 3
    Explanation: 10/3 = truncate(3.33333..) = 3.
    Example 2:

    Input: dividend = 7, divisor = -3
    Output: -2
    Explanation: 7/-3 = truncate(-2.33333..) = -2.
    Example 3:

    Input: dividend = 0, divisor = 1
    Output: 0
    Example 4:

    Input: dividend = 1, divisor = 1
    Output: 1


    Constraints:

    -231 <= dividend, divisor <= 231 - 1
    divisor != 0

 */
public class DivideTwoIntegersTest {

    @Test
    public void test() {

        int actual1 = divide(-2147483648, 2);
        Assertions.assertEquals(-1073741824, actual1);

        int actual2 = divide(10, 3);
        Assertions.assertEquals(3, actual2);

        int actual3 = divide(7, -3);
        Assertions.assertEquals(-2, actual3);

        int actual4 = divide(0, 1);
        Assertions.assertEquals(0, actual4);

        int actual5 = divide(1, 1);
        Assertions.assertEquals(1, actual5);
    }

    public int divide(int dividend, int divisor) {

        if (dividend == 0 || divisor == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long lDividend = Math.abs(Long.valueOf(dividend));
        long lDivisor = Math.abs(Long.valueOf(divisor));

        if (Math.abs(divisor) == 1) {
            return isNegative? (int)-lDividend : (int)lDividend;
        }

        int result = 0;
        while (lDividend >= lDivisor) {
            lDividend -= lDivisor;
            if (lDividend >= 0) {
                result++;
            }
        }

        return isNegative? -result : result;
    }

    public int divide2(int dividend, int divisor) {

        // Check for overflow
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        // Sign of result
        int sign = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0) ? -1 : 1;
        // Quotient
        int quotient = 0;
        // Take the absolute value
        long absoluteDividend = Math.abs((long) dividend);
        long absoluteDivisor = Math.abs((long) divisor);
        // Loop until the  dividend is greater than divisor
        while (absoluteDividend >= absoluteDivisor) {
            // This represents the number of bits shifted or
            // how many times we can double the number
            int shift = 0;
            while (absoluteDividend >= (absoluteDivisor << shift)) {
                shift++;
            }
            // Add the number of times we shifted to the quotient
            quotient += (1 << (shift - 1));
            // Update the dividend for the next iteration
            absoluteDividend -= absoluteDivisor << (shift - 1);
        }
        return sign == -1 ? -quotient : quotient;
    }
}
