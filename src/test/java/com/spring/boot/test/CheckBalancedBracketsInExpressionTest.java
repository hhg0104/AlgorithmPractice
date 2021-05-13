package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class CheckBalancedBracketsInExpressionTest {


    @Test
    public void test() {

        boolean isBalanced = isBalancedBrackets("[()]{}{[()()]()}");
        Assertions.assertTrue(isBalanced);

        boolean isBalanced2 = isBalancedBrackets("[(])");
        Assertions.assertFalse(isBalanced2);
    }

    private boolean isBalancedBrackets(String exp) {

        Deque<Character> stack = new ArrayDeque<>();

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
