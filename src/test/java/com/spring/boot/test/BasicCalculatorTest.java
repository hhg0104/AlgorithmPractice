package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BasicCalculatorTest {

    @Test
    public void test() {

        int result = calculate2("321-3*5+12-11");

        Assertions.assertEquals(307, result);
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
