package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseIntegerTest {

    @Test
    public void test() {

        int actual1 = reverse(321);
        Assertions.assertEquals(123, actual1);

        int actual2 = reverse(-123);
        Assertions.assertEquals(-321, actual2);

        int actual3 = reverse(120);
        Assertions.assertEquals(21, actual3);

        int actual4 = reverse(0);
        Assertions.assertEquals(0, actual4);
    }

    public int reverse(int x) {

        int reverse = 0;

        while (x != 0) {
            int num = x % 10;
            x = x / 10;

            if (reverse > Integer.MAX_VALUE / 10 ||
                    (reverse == Integer.MAX_VALUE / 10 && num > 7)) {
                return 0;
            }

            if (reverse < Integer.MIN_VALUE / 10 ||
                    (reverse == Integer.MIN_VALUE / 10 && num < -8)) {
                return 0;
            }

            reverse = reverse * 10 + num;
        }

        return reverse;
    }
}
