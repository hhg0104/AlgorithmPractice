package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

/*
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.


    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
    Example 3:

    Input: s = "(]"
    Output: false
    Example 4:

    Input: s = "([)]"
    Output: false
    Example 5:

    Input: s = "{[]}"
    Output: true


    Constraints:

    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
 */
public class IsValidParenthesesTest {

    @Test
    public void test() {

        boolean actual1 = isValid("()");
        Assertions.assertTrue(actual1);

        boolean actual2 = isValid("()[]{}");
        Assertions.assertTrue(actual2);

        boolean actual3 = isValid("(]");
        Assertions.assertFalse(actual3);

        boolean actual4 = isValid("([)]");
        Assertions.assertFalse(actual4);

        boolean actual5 = isValid("{[]}");
        Assertions.assertTrue(actual5);
    }

    private boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();

        if (s.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);

            } else if(ch == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if(ch == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if(ch == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
