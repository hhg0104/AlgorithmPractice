package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

public class BasicCalculatorTest {

    @Test
    public void test() {

        int result1 = calculateWithStack("321-3*5+12-11");
        Assertions.assertEquals(307, result1);

        int result2 = calculateWithStack("-11 + 3 + 4 - 5");
        Assertions.assertEquals(-9, result2);

        int result3 = calculateWithStack("3+2*2");
        Assertions.assertEquals(7, result3);
    }

    private int calculateWithStack(String str) {

        int currentNum = 0;
        char operand = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if(Character.isDigit(ch)) {
                currentNum = currentNum * 10 + (ch - '0');

            } else if(!Character.isWhitespace(ch)) {
                expr(stack, currentNum, operand);

                operand = ch;
                currentNum = 0;
            }
        }

        if (currentNum != 0) {
            expr(stack, currentNum, operand);
        }

        int result = 0;
        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    private void expr(Stack<Integer> stack, int currentNum, char operand) {
        if (operand == '+' || operand == '-') {
            currentNum = (operand == '+')? currentNum : -currentNum;
            stack.push(currentNum);

        } else if (operand == '*') {
            int lastNum = stack.pop();
            stack.push(lastNum * currentNum);

        } else if (operand == '/') {
            int lastNum = stack.pop();
            stack.push(lastNum / currentNum);
        }
    }

    private int calculate2(String str) {

        if (str == null || str.isEmpty()) {
            return 0;
        }

        int currentNum = 0;
        int lastNum = 0;
        int result = 0;
        char operation = '+';

        int length = str.length();
        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                currentNum = (currentNum * 10) + (ch - '0');
            }

            if (!Character.isDigit(ch) && !Character.isWhitespace(ch) || i == length - 1) {

                if (operation == '+' || operation == '-') {
                    result += lastNum;
                    lastNum = (operation == '+') ? currentNum : -currentNum;

                } else if (operation == '*') {
                    lastNum = lastNum * currentNum;

                } else if (operation == '/') {
                    lastNum = lastNum / currentNum;
                }

                operation = ch;
                currentNum = 0;
            }
        }

        result += lastNum;
        return result;
    }

    private int calculate(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int currentNumber = 0;
        int lastNumber = 0;
        int result = 0;

        char operation = '+';

        int length = s.length();
        for (int i = 0; i < length; i++) {

            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)) {
                currentNumber = (currentNumber * 10) + (currentChar - '0');
            }

            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1) {

                if (operation == '+' || operation == '-') {
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currentNumber : -currentNumber;

                } else if (operation == '*') {
                    lastNumber = lastNumber * currentNumber;

                } else if (operation == '/') {
                    lastNumber = lastNumber / currentNumber;
                }

                operation = currentChar;
                currentNumber = 0;
            }
        }

        result += lastNumber;
        return result;
    }
}
