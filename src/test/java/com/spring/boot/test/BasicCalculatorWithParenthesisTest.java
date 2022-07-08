package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given a string s representing a valid expression, implement a basic calculator to evaluate it,
    and return the result of the evaluation.

    Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
    such as eval().


    Example 1:

    Input: s = "1 + 1"
    Output: 2
    Example 2:

    Input: s = " 2-1 + 2 "
    Output: 3
    Example 3:

    Input: s = "(1+(4+5+2)-3)+(6+8)"
    Output: 23
    Example 4:

    Input: s = "+48 + -48"
    Output: 0
    Explanation: Numbers can have multiple digits and start with +/-.


    Constraints:

    1 <= s.length <= 3 * 105
    s consists of digits, '+', '-', '(', ')', and ' '.
    s represents a valid expression.
    Every number and running calculation will fit in a signed 32-bit integer.
 */
public class BasicCalculatorWithParenthesisTest {

    @Test
    public void test() {

        int result1 = calculate("1 + 1");
        Assertions.assertEquals(2, result1);

        int result2 = calculate(" 2-1 + 2 ");
        Assertions.assertEquals(3, result2);

        int result3 = calculate("(1+(4+5+2)-3)+(6+8)");
        Assertions.assertEquals(23, result3);

        int result4 = calculate("+48 + -48");
        Assertions.assertEquals(0, result4);

        int result5 = calculate("- (3 + (4 + 5))");
        Assertions.assertEquals(-12, result5);

        int result6 = calculate("(7)-(0)+(4)");
        Assertions.assertEquals(11, result6);
    }

    private int calculate(String str) {

        return -1;
    }
}
