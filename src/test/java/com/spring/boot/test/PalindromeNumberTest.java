package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PalindromeNumberTest {

    @Test
    public void test() {

        boolean actual1 = isPalindrome(121);
        Assertions.assertTrue(actual1);

        boolean actual2 = isPalindrome(-121);
        Assertions.assertFalse(actual2);

        boolean actual3 = isPalindrome(10);
        Assertions.assertFalse(actual3);

        boolean actual4 = isPalindrome(-101);
        Assertions.assertFalse(actual4);

        boolean actual5 = isPalindrome(5);
        Assertions.assertTrue(actual5);
    }

    private boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int temp = x;
        int reverse = 0;

        while (temp != 0) {
           int rest = temp % 10;
           temp = temp / 10;
           reverse = reverse * 10 + rest;
        }

        return x == reverse;
    }
}
