package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class CheckBalancedBracketsInExpressionTest {

    @Test
    public void test() {

        boolean isBalanced = isBalancedBrackets("[()]{}{[()()]()}");
        Assertions.assertTrue(isBalanced);

        boolean isBalanced2 = isBalancedBrackets("[(])");
        Assertions.assertFalse(isBalanced2);
    }

    private boolean isBalancedBrackets(String exp) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            if (ch == ')') {
                char popCh = stack.pop();
                if(popCh == '{' || popCh == '[') {
                    return false;
                }

            } else if (ch == '}') {
                char popCh = stack.pop();
                if(popCh == '(' || popCh == '[') {
                    return false;
                }

            } else if (ch == ']') {
                char popCh = stack.pop();
                if(popCh == '(' || popCh == '{') {
                    return false;
                }
            }
        }

        return (stack.isEmpty());
    }
}
